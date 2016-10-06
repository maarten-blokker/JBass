package com.github.jbass.metadata;

import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author Maarten
 */
public interface BassMetadataExtractor {

    BassMetadata extract(Path directory) throws IOException;
    
}
