package com.github.jbass.impl;

import com.github.jbass.metadata.CallbackMetadata;
import com.github.jbass.metadata.FunctionMetadata;
import com.github.jbass.metadata.PropertyMetadata;
import com.github.jbass.metadata.StructMetadata;
import com.github.jbass.metadata.BassMetadata;
import com.github.jbass.metadata.BassMetadataExtractor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Maarten
 */
public class JSoupBassMetadataExtractor implements BassMetadataExtractor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSoupBassMetadataExtractor.class);

    private static final Pattern PATTERN_FUNCTION = Pattern.compile(
            "([\\w]*?)\\s*(\\*?\\w+)\\s*\\([\\);]*"
    );

    private static final Pattern PATTERN_CALLBACK = Pattern.compile(
            "([\\w]+) CALLBACK ([\\w]+).*"
    );

    private static final Pattern PATTERN_PROPERTY = Pattern.compile(
            "(const|unsigned|signed)?\\s?\\*?(\\w+)\\*? \\*?(\\w+)\\*?\\s*(?:\\[(\\d*)\\])?"
    );

    private static final String TAG_STRUCT_DECLARATION = "typedef struct";
    private static final String CHARSET_NAME = "utf8";

    @Override
    public BassMetadata extract(Path directory) throws IOException {
        BassMetadata metadata = new BassMetadata();

        List<Path> documents = Files.walk(directory, FileVisitOption.FOLLOW_LINKS)
                .filter((path) -> path.toString().toLowerCase().endsWith(".html"))
                .collect(Collectors.toList());
        for (Path path : documents) {
            extractMetadata(path, metadata);
        }

        return metadata;
    }

    private void extractMetadata(Path path, BassMetadata metadata) throws IOException {
        try (InputStream in = Files.newInputStream(path)) {
            Document doc = Jsoup.parse(in, CHARSET_NAME, "");

            parseStruct(doc).ifPresent(metadata.getStructMetadata()::add);
            parseFunction(doc).ifPresent(metadata.getFunctionMetadata()::add);
            parseCallback(doc).ifPresent(metadata.getCallbackMetadata()::add);
        }
    }

    /**
     * Parse the given document as a struct documentation.
     *
     * @param doc
     * @return
     */
    private Optional<StructMetadata> parseStruct(Document doc) {
        String text = getDefinitionText(doc);
        if (text == null) {
            return Optional.empty();
        }

        String[] lines = text.split("\r\n");
        if (lines.length < 2 || !lines[0].startsWith(TAG_STRUCT_DECLARATION)) {
            return Optional.empty();
        }

        //the assumption is made that the first table describes the members
        Map<String, String> documentation = parseTable(doc.select("table").first());

        StructMetadata struct = new StructMetadata();
        struct.setName(sanitize(lines[lines.length - 1].substring(1)).toUpperCase());
        for (int i = 1; i < lines.length - 1; i++) {
            PropertyMetadata property = parseProperty(sanitize(lines[i]));
            if (property == null) {
                LOGGER.trace("encountered invalid property in struct: {}", struct.getName());
                return Optional.empty();
            }

            property.setDocumentation(documentation.get(property.getName()));
            struct.getProperties().add(property);
        }

        return Optional.of(struct);
    }

    /**
     * Parse the document as function documentation.
     *
     * @param doc
     * @return
     */
    private Optional<FunctionMetadata> parseFunction(Document doc) {
        String text = getDefinitionText(doc);
        if (text == null) {
            return Optional.empty();
        }

        String[] lines = text.split("\r\n");
        if (lines.length < 1) {
            return Optional.empty();
        }

        Matcher matcher = PATTERN_FUNCTION.matcher(lines[0]);
        if (!matcher.matches() || matcher.groupCount() != 2) {
            return Optional.empty();
        }

        boolean pointer = false;
        String returnType = matcher.group(1);
        if (returnType == null || returnType.isEmpty()) {
            return Optional.empty();
        }

        String name = matcher.group(2);
        if (name.contains("*")) {
            name = name.replaceAll("\\*", "");
        }

        PropertyMetadata result = parseReturnType(returnType);
        result.setPointer(pointer);

        FunctionMetadata metadata = new FunctionMetadata();
        metadata.setResult(result);
        metadata.setName(name);

        if (lines.length > 2) {
            //the assumption is made that the first table describes the members
            Map<String, String> documentation = parseTable(doc.select("table").first());

            for (int i = 1; i < lines.length - 1; i++) {
                PropertyMetadata property = parseProperty(sanitize(lines[i].trim()));
                if (property == null) {
                    LOGGER.trace("encountered invalid property in struct: {}", name);
                    return Optional.empty();
                }

                property.setDocumentation(documentation.get(property.getName()));
                metadata.getParameters().add(property);
            }
        }

        return Optional.of(metadata);
    }

    private Optional<CallbackMetadata> parseCallback(Document doc) {
        String text = getDefinitionText(doc);
        if (text == null) {
            return Optional.empty();
        }

        String[] lines = text.split("\r\n");
        if (lines.length < 2) {
            return Optional.empty();
        }

        Matcher matcher = PATTERN_CALLBACK.matcher(lines[0]);
        if (!matcher.matches() || matcher.groupCount() != 2) {
            return Optional.empty();
        }

        CallbackMetadata metadata = new CallbackMetadata();
        metadata.setResult(parseReturnType(matcher.group(1)));
        metadata.setName(matcher.group(2).toUpperCase());

        //the assumption is made that the first table describes the members
        Map<String, String> documentation = parseTable(doc.select("table").first());

        for (int i = 1; i < lines.length - 1; i++) {
            PropertyMetadata property = parseProperty(sanitize(lines[i]));
            if (property == null) {
                LOGGER.trace("encountered invalid property in callback: {}", metadata.getName());
                return Optional.empty();
            }
            property.setDocumentation(documentation.get(property.getName()));
            metadata.getParameters().add(property);
        }

        return Optional.of(metadata);
    }

    private PropertyMetadata parseProperty(String text) {
        boolean pointer = false;
        if (text.contains("*")) {
            text = text.replaceAll("\\*", "");
            pointer = true;
        }

        Matcher matcher = PATTERN_PROPERTY.matcher(text);
        if (!matcher.matches()) {
            return null;
        }

        String modifier = matcher.group(1);
        String type = matcher.group(2);
        String name = matcher.group(3);
        int arraySize = 0;

        //try to detect an array
        if (matcher.group(4) != null) {
            if (matcher.group(4).isEmpty()) {
                //no array size, something is fishy, probably a string
                if (type.equals("char")) {
                    pointer = true;
                }
            } else {
                arraySize = Integer.parseInt(matcher.group(4));
            }
        }

        PropertyMetadata metadata = new PropertyMetadata();
        metadata.setModifier(modifier);
        metadata.setType(type);
        metadata.setName(name);
        metadata.setArraySize(arraySize);
        metadata.setPointer(pointer);

        return metadata;
    }

    private PropertyMetadata parseReturnType(String text) {
        text = text.trim();

        if (text.isEmpty()) {
            return null;
        }

        PropertyMetadata property = new PropertyMetadata();
        property.setName("return");

        if (text.startsWith("*") || text.endsWith("*")) {
            text = text.replaceAll("\\*", "");
            property.setPointer(true);

        }

        property.setType(text);

        return property;
    }

    private String getDefinitionText(Document doc) {
        Element definition = doc.select(".def").first();
        if (definition == null || !definition.tagName().equals("pre")) {
            return null;
        }

        return definition.text();
    }

    private Map<String, String> parseTable(Element table) {
        if (table == null) {
            return Collections.emptyMap();
        }

        Map<String, String> result = new HashMap<>();
        Elements rows = table.child(0).children();

        for (int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");

            if (cols.size() < 2) {
                continue;
            }
            result.put(cols.get(0).text(), cols.get(1).html());
        }

        return result;
    }

    private String sanitize(String input) {
        input = input.trim();

        if (input.endsWith(";") || input.endsWith(",")) {
            input = input.substring(0, input.length() - 1);
        }

        return input;
    }

    public static void main(String[] args) throws IOException {
        BassMetadata meta = new JSoupBassMetadataExtractor().extract(Paths.get("C:\\workspace\\JBass\\JBass\\bass_docs"));
        System.out.println(meta.getFunctionMetadata());

//        for (CallbackMetadata callback : meta.getCallbackMetadata()) {
//            String out = gen.generateCallback("com.git", callback);
//            System.out.println(" ******   " + callback.getName() + "    ****** ");
//            System.out.println(out);
//            System.out.println();
//        }
//
//        for (StructMetadata struct : meta.getStructMetadata()) {
//            String out = gen.generateStruct("com.git", struct);
//            System.out.println(" ******   " + struct.getName() + "    ****** ");
//            System.out.println(out);
//            System.out.println();
//        }
//        List<String> inputs = Arrays.asList(
//                "const void buf",
//                "const void* buf",
//                "const *void buf",
//                "const void *buf",
//                "const void buf*",
//                "unsigned int handle",
//                "signed int handle",
//                "char a",
//                "char a*",
//                "char *a",
//                "char* a",
//                "*char a"
//        );
//
//        Pattern p = Pattern.compile("(const|unsigned|signed)?\\s?\\*?(\\w+)\\*? \\*?(\\w+)\\*?");
//        inputs.forEach((input) -> {
//            Matcher m = p.matcher(input);
//            System.out.println((m.matches() ? "[X]" : "[ ]") + " input = " + input);
//
//            if (m.matches()) {
//                for (int i = 1; i <= m.groupCount(); i++) {
//                    System.out.println("\t" + i + " - " + m.group(i));
//                }
//            }
//        });
    }
}
