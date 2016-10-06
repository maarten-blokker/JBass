package com.github.jbass.metadata;

import com.github.jbass.metadata.BassMetadata;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author Maarten
 */
public interface ClassGenerator {

    Map<String, String> generateClasses(String packageName, BassMetadata metadata) throws IOException;

}
