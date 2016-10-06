package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassStreamFile {

    /**
     * Read the file asynchronously. When enabled, the file is read and buffered
     * in parallel with the decoding, to reduce the chances of the decoder being
     * affected by I/O delays. This can be particularly useful with slow storage
     * media and/or low latency output. The size of the file buffer is
     * determined by the
     * {@link BassConfig#BASS_CONFIG_ASYNCFILE_BUFFER BASS_CONFIG_ASYNCFILE_BUFFER}
     * config option. This flag is ignored when streaming from memory (mem =
     * TRUE).
     */
    public static final int BASS_ASYNCFILE = 0x40000000;

    /**
     * file is in UTF-16 form. Otherwise it is ANSI on Windows or Windows CE,
     * and UTF-8 on other platforms.
     */
    public static final int BASS_UNICODE = 0x80000000;

    /**
     * Unbuffered
     */
    public static final int STREAMFILE_NOBUFFER = 0;

    /**
     * Buffered
     */
    public static final int STREAMFILE_BUFFER = 1;

    /**
     * Buffered, with the data pushed to BASS via BASS_StreamPutFileData.
     */
    public static final int STREAMFILE_BUFFERPUSH = 2;

}
