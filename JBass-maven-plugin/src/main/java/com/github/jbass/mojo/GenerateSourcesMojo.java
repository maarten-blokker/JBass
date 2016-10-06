package com.github.jbass.mojo;

import com.github.jbass.impl.DefaultClassGenerator;
import com.github.jbass.impl.JSoupBassMetadataExtractor;
import com.github.jbass.metadata.BassMetadata;
import com.github.jbass.metadata.BassMetadataExtractor;
import com.github.jbass.metadata.ClassGenerator;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 *
 * @author MBlokker
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class GenerateSourcesMojo extends AbstractMojo {

    public static final String IMPLEMENTATION_HTML = "html";

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    /**
     * The path to resource directory
     */
    @Parameter(property = "jbass.plugin.directory.source", required = true)
    private File metadataDirectory;

    /**
     * Implementation used to extract metadata
     */
    @Parameter(property = "jbass.plugin.implementation", defaultValue = "html")
    private String implementation;

    /**
     * The path to resource directory
     */
    @Parameter(property = "jbass.plugin.directory.target", defaultValue = "${project.build.directory}/generated-sources/bass")
    private File targetDirectory;

    @Parameter(property = "jbass.plugin.packagename", defaultValue = "${project.groupId}")
    private String packageName;

    private ClassGenerator classGenerator = new DefaultClassGenerator();

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Starting jbass maven plugin");
        getLog().info("Metadata directory:      " + this.metadataDirectory);
        getLog().info("Metadata implementation: " + this.implementation);

        if (this.metadataDirectory == null
                || !this.metadataDirectory.exists()) {
            throw new MojoExecutionException("metadata directory does not exist: " + this.metadataDirectory);
        }

        BassMetadata metadata = extractMetadata();
        getLog().info("Found " + metadata.getFunctionMetadata().size() + " functions");
        getLog().info("Found " + metadata.getStructMetadata().size() + " structs");
        getLog().info("Found " + metadata.getCallbackMetadata().size() + " callbacks");

        try {
            Map<String, String> generatedClasses = this.classGenerator.generateClasses(this.packageName, metadata);
            for (String className : generatedClasses.keySet()) {
                writeJavaFile(className, generatedClasses.get(className));
            }
        } catch (IOException ex) {
            throw new MojoExecutionException("Failed to write generated file", ex);
        }

        this.project.addCompileSourceRoot(this.targetDirectory.getAbsolutePath());
    }

    private BassMetadata extractMetadata() throws MojoExecutionException {
        BassMetadataExtractor extractor;
        switch (this.implementation.toLowerCase()) {
            case IMPLEMENTATION_HTML:
                extractor = new JSoupBassMetadataExtractor();
                break;
            default:
                throw new MojoExecutionException(
                        "Unknown metadata implementation: " + this.implementation
                );
        }

        BassMetadata metadata;
        try {
            metadata = extractor.extract(this.metadataDirectory.toPath());
        } catch (IOException ex) {
            throw new MojoExecutionException("Failed to extract metadata form directory", ex);
        }

        return metadata;
    }

    private void writeJavaFile(String className, String output) throws IOException {
        String part = className.substring(0, className.lastIndexOf("."));

        int index = part.lastIndexOf(".");
        String classPackage = part.substring(0, index);
        String filename = className.substring(index + 1);

        File packageDir = new File(this.targetDirectory, classPackage.replaceAll("\\.", "/"));
        if (!packageDir.exists() && !packageDir.mkdirs()) {
            throw new IOException(""
                    + "Directory " + packageDir.getAbsolutePath()
                    + " does not exist and could not be created");
        }

        File file = new File(packageDir, filename);
        getLog().info("Writing to file: " + file);

        byte[] data = output.getBytes(StandardCharsets.UTF_8);
        Files.write(file.toPath(), data, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
    }

}
