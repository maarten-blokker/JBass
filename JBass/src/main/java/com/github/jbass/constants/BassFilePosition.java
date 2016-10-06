package com.github.jbass.constants;

/**
 *
 * @author Maarten
 */
public interface BassFilePosition {

    public static final int BASS_FILEPOS_CURRENT = 0;
    public static final int BASS_FILEPOS_DECODE = BASS_FILEPOS_CURRENT;
    public static final int BASS_FILEPOS_DOWNLOAD = 1;
    public static final int BASS_FILEPOS_END = 2;
    public static final int BASS_FILEPOS_START = 3;
    public static final int BASS_FILEPOS_CONNECTED = 4;
    public static final int BASS_FILEPOS_BUFFER = 5;
    public static final int BASS_FILEPOS_SOCKET = 6;
    public static final int BASS_FILEPOS_ASYNCBUF = 7;
    public static final int BASS_FILEPOS_SIZE = 8;

}
