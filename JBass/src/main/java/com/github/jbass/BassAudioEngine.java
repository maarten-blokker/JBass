package com.github.jbass;

import com.github.jbass.struct.BASS_DEVICEINFO;
import java.io.IOException;
import jnr.ffi.LibraryLoader;

/**
 *
 * @author Maarten
 */
public class BassAudioEngine {

    private static BassDelegate DELEGATE;

    public static void initialize() throws IOException {
        DELEGATE = LibraryLoader.create(BassDelegate.class)
                .failImmediately()
                .search(BassLibraries.getLibraryPath().getAbsolutePath())
                .load("bass");
    }

    public static BassDelegate getDelegate() {
        return DELEGATE;
    }

}
