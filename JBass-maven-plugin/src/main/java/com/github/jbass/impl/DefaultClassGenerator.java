package com.github.jbass.impl;

import com.github.jbass.metadata.BassMetadata;
import com.github.jbass.metadata.CallbackMetadata;
import com.github.jbass.metadata.ClassGenerator;
import com.github.jbass.metadata.FunctionMetadata;
import com.github.jbass.metadata.PropertyMetadata;
import com.github.jbass.metadata.StructMetadata;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maarten
 */
public class DefaultClassGenerator implements ClassGenerator {

    public static final String TEMPLATE_DELEGATE = "delegate";
    public static final String TEMPLATE_STRUCT = "struct";
    public static final String TEMPLATE_CALLBACK = "callback";

    @Override
    public Map<String, String> generateClasses(String packageName, BassMetadata metadata) throws IOException {
        Handlebars handlebars = new Handlebars(new ClassPathTemplateLoader("/templates"));
        handlebars.registerHelper("javatype", (PropertyMetadata context, Options options) -> {
            return getJavaType(context);
        });
        handlebars.registerHelper("structmember", (PropertyMetadata context, Options options) -> {
            return getStructMember(metadata, context);
        });

        Template delegateTemplate = handlebars.compile(TEMPLATE_DELEGATE);
        Template structTemplate = handlebars.compile(TEMPLATE_STRUCT);
        Template callbackTemplate = handlebars.compile(TEMPLATE_CALLBACK);

        Map<String, String> result = new HashMap<>();
        result.put(packageName + ".BassDelegate.java",
                delegateTemplate.apply(createContext(packageName, metadata.getFunctionMetadata())));

        String structPackage = packageName + ".struct";
        for (StructMetadata struct : metadata.getStructMetadata()) {
            String className = structPackage + "." + struct.getName() + ".java";
            String structRender = structTemplate.apply(createContext(structPackage, struct));
            result.put(className, structRender);
        }

        String callbackPackage = packageName + ".callback";
        for (CallbackMetadata callback : metadata.getCallbackMetadata()) {
            String className = callbackPackage + "." + callback.getName() + ".java";
            String callbackRender = callbackTemplate.apply(createContext(callbackPackage, callback));
            result.put(className, callbackRender);
        }

        return result;
    }

    private Map<String, Object> createContext(String packageName, List<FunctionMetadata> functions) {
        Map<String, Object> context = new HashMap<>();
        context.put("packageName", packageName);
        context.put("functions", functions);

        return context;
    }

    private Map<String, Object> createContext(String packageName, StructMetadata struct) throws IOException {
        Map<String, Object> context = new HashMap<>();
        context.put("packageName", packageName);
        context.put("struct", struct);

        return context;
    }

    private Map<String, Object> createContext(String packageName, CallbackMetadata callback) throws IOException {
        Map<String, Object> context = new HashMap<>();
        context.put("packageName", packageName);
        context.put("callback", callback);

        return context;
    }

    private String getJavaType(PropertyMetadata metadata) {
        String type = metadata.getType();
        switch (type) {
            case "BOOL":
                type = "boolean";
                break;
            case "DWORD":
            case "HMUSIC":
            case "HSAMPLE":
            case "HCHANNEL":
            case "HSTREAM":
            case "HRECORD":
            case "HSYNC":
            case "HDSP":
            case "HFX":
            case "HPLUGIN":
            case "HWND":
            case "GUID":
                type = "int";
                break;
            case "QWORD":
                type = "long";
                break;
        }

        if (type.equals("char") && metadata.isPointer()) {
            type = "String";
        } else if (type.equals("void") && metadata.isPointer()) {
            type = "ByteBuffer";
        }

        return type;
    }

    private String getStructType(PropertyMetadata metadata) {
        if (metadata.getType() == null) {
            return null;
        } else if (metadata.getType().equals("char")) {
            if (metadata.isPointer()) {
                return "UTF8StringRef";
            } else if (metadata.getArraySize() > 0) {
                return "AsciiString";
            }
        }

        switch (metadata.getType()) {
            case "BOOL":
                return "Boolean";
            case "BYTE":
                return "Signed8";
            case "WORD":
                return "u_int16_t";
            case "DWORD":
            case "HMUSIC":
            case "HSAMPLE":
            case "HCHANNEL":
            case "HSTREAM":
            case "HRECORD":
            case "HSYNC":
            case "HDSP":
            case "HFX":
            case "HPLUGIN":
                return "u_int32_t";
            case "QWORD":
                return "Unsigned32";
            case "float":
                return "Float";
            case "double":
                return "Double";
            case "void":
                return "Pointer";
            case "int":
                return "int32_t";
            default:
                return metadata.getType();
        }
    }

    private String getStructMember(BassMetadata metadata, PropertyMetadata property) {
        String name = property.getName();
        String type = getStructType(property);
        StringBuilder sb = new StringBuilder();
        if (isStringType(property) || property.getArraySize() == 0) {
            sb.append(type).append(" ").append(name);
            if (!isCallback(metadata, property)) {
                sb.append(" = new ").append(type);
                if (property.getArraySize() > 0) {
                    sb.append("(").append(property.getArraySize()).append(")");
                } else {
                    sb.append("()");
                }
            }
        } else {
            sb.append(type).append(" ").append(name).append("[] = ");

            if (isStruct(metadata, property)) {
                sb.append("arrayOf(jnr.ffi.Runtime.getRuntime(BassAudioEngine.getDelegate()), ")
                        .append(type).append(".class, ")
                        .append(property.getArraySize()).append(")");
            } else {
                sb.append("array(new ").append(type)
                        .append("[").append(property.getArraySize()).append("]")
                        .append(")");
            }
        }

        return sb.toString();
    }

    private boolean isStringType(PropertyMetadata property) {
        return property.getType().equals("char")
                && (property.isPointer() || property.getArraySize() > 0);
    }

    private boolean isStruct(BassMetadata metadata, PropertyMetadata property) {
        return metadata.getStructMetadata().stream()
                .anyMatch((struct) -> struct.getName().equals(property.getType()));
    }

    private boolean isCallback(BassMetadata metadata, PropertyMetadata property) {
        return metadata.getCallbackMetadata().stream()
                .anyMatch((calback) -> calback.getName().equals(property.getType()));
    }

    public static void main(String[] args) throws IOException {
        BassMetadata meta = new JSoupBassMetadataExtractor().extract(Paths.get("C:\\workspace\\JBass\\JBass\\bass_docs"));
        new DefaultClassGenerator().generateClasses("com.jbass", meta);
    }
}
