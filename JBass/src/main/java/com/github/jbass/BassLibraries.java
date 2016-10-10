package com.github.jbass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Maarten
 */
public class BassLibraries {

    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
    private static final String OS_ARCH = System.getProperty("os.arch").toLowerCase();
    private static final String APPDATA = System.getenv("APPDATA");
    private static final String NATIVE_RESOURCE = "/natives.zip";

    private static final OperatingSystem OS = OperatingSystem.detect();

    public enum OperatingSystem {

        Win, Mac, Unix;

        public static OperatingSystem detect() {
            if (OS_NAME.contains("win")) {
                return Win;
            } else if (OS_NAME.contains("mac")) {
                return Mac;
            } else if (OS_NAME.contains("nux")) {
                return Unix;
            } else {
                throw new IllegalStateException("Failed to detect operating system");
            }
        }
    }

    /**
     * Get the path to the native library files on disk. If the native library
     * files do not exist, an attempt will be made to extract them from the
     * resource directory.
     *
     * @return the directory where the library files can be found
     * @throws java.io.IOException throws an exception if the files could not be
     * extracted or verified.
     */
    public static File getLibraryPath() throws IOException {
        return getLibraryPath(OS, isX86Bit());
    }

    /**
     * Get the path to the native library files on disk. If the native library
     * files do not exist, an attempt will be made to extract them from the
     * resource directory.
     *
     * @param os the operating system the library files need to service
     * @param x86 the cpu architecture the library files need to service
     * @return the directory where the library files can be found
     * @throws java.io.IOException throws an exception if the files could not be
     * extracted or verified.
     */
    public static File getLibraryPath(OperatingSystem os, boolean x86) throws IOException {
        String subdirectory = os.name() + (x86 ? "" : "64");

        File appData = new File(APPDATA);
        File bassNatives = new File(appData, "bass_natives");
        File libraryDir = new File(bassNatives, subdirectory);
        if (!libraryDir.exists() && !libraryDir.mkdirs()) {
            throw new RuntimeException("Failed to create required native directory: " + libraryDir.getAbsolutePath());
        }

        try {
            extractNativeResources(bassNatives, subdirectory);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to extract natives to directory", ex);
        }

        return libraryDir;
    }

    /**
     * Extract the native resources to the specified the directory.
     *
     * @param targetDirectory the directory to extract resources to
     * @param subdirectory the subdirectory in the target directory and native
     * resource directory to extract to/from
     * @throws IOException
     */
    private static void extractNativeResources(File targetDirectory, String subdirectory) throws IOException {
        byte[] buffer = new byte[1024];
        InputStream resource = BassLibraries.class.getResourceAsStream(NATIVE_RESOURCE);
        try (ZipInputStream in = new ZipInputStream(resource)) {
            ZipEntry entry;
            while ((entry = in.getNextEntry()) != null) {
                if (entry.isDirectory() || !entry.getName().startsWith(subdirectory)) {
                    continue;
                }

                //check if the file exists
                File target = new File(targetDirectory, entry.getName());
                if (target.exists()) {
                    long targetCrc = getCrcChecksum(target);
                    long requiredCrc = entry.getCrc();
                    if (targetCrc == requiredCrc) {
                        continue;
                    }
                }

                //file does not exist, so extract it
                try (FileOutputStream fos = new FileOutputStream(target)) {
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    /**
     * Computes a CRC checksum of a file.
     *
     * @param file the file to create a checksum for
     * @return the computed CRC checksum
     * @throws IOException throws an IOException if the file could not be read
     */
    private static long getCrcChecksum(File file) throws IOException {
        CRC32 crc = new CRC32();

        try (FileInputStream inputStream = new FileInputStream(file)) {
            FileChannel channel = inputStream.getChannel();
            crc.update(channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size()));
        }

        return crc.getValue();
    }

    private static boolean isX86Bit() {
        return OS_ARCH.equals("x86");
    }
}
