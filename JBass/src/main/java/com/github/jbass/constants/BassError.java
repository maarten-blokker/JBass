package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassError {

    /**
     * all is OK
     */
    public static final int BASS_OK = 0;

    /**
     * memory error
     */
    public static final int BASS_ERROR_MEM = 1;

    /**
     * can't open the file
     */
    public static final int BASS_ERROR_FILEOPEN = 2;

    /**
     * can't find a free/valid driver
     */
    public static final int BASS_ERROR_DRIVER = 3;

    /**
     * the sample buffer was lost
     */
    public static final int BASS_ERROR_BUFLOST = 4;

    /**
     * invalid handle
     */
    public static final int BASS_ERROR_HANDLE = 5;

    /**
     * unsupported sample format
     */
    public static final int BASS_ERROR_FORMAT = 6;

    /**
     * invalid position
     */
    public static final int BASS_ERROR_POSITION = 7;

    /**
     * BASS_Init has not been successfully called
     */
    public static final int BASS_ERROR_INIT = 8;

    /**
     * BASS_Start has not been successfully called
     */
    public static final int BASS_ERROR_START = 9;

    /**
     * SSL/HTTPS support isn't available
     */
    public static final int BASS_ERROR_SSL = 10;

    /**
     * already initialized/paused/whatever
     */
    public static final int BASS_ERROR_ALREADY = 14;

    /**
     * can't get a free channel
     */
    public static final int BASS_ERROR_NOCHAN = 18;

    /**
     * an illegal type was specified
     */
    public static final int BASS_ERROR_ILLTYPE = 19;

    /**
     * an illegal parameter was specified
     */
    public static final int BASS_ERROR_ILLPARAM = 20;

    /**
     * no 3D support
     */
    public static final int BASS_ERROR_NO3D = 21;

    /**
     * no EAX support
     */
    public static final int BASS_ERROR_NOEAX = 22;

    /**
     * illegal device number
     */
    public static final int BASS_ERROR_DEVICE = 23;

    /**
     * not playing
     */
    public static final int BASS_ERROR_NOPLAY = 24;

    /**
     * illegal sample rate
     */
    public static final int BASS_ERROR_FREQ = 25;

    /**
     * the stream is not a file stream
     */
    public static final int BASS_ERROR_NOTFILE = 27;

    /**
     * no hardware voices available
     */
    public static final int BASS_ERROR_NOHW = 29;

    /**
     * the MOD music has no sequence data
     */
    public static final int BASS_ERROR_EMPTY = 31;

    /**
     * no internet connection could be opened
     */
    public static final int BASS_ERROR_NONET = 32;

    /**
     * couldn't create the file
     */
    public static final int BASS_ERROR_CREATE = 33;

    /**
     * effects are not available
     */
    public static final int BASS_ERROR_NOFX = 34;

    /**
     * requested data is not available
     */
    public static final int BASS_ERROR_NOTAVAIL = 37;

    /**
     * the channel is/isn't a "decoding channel"
     */
    public static final int BASS_ERROR_DECODE = 38;

    /**
     * a sufficient DirectX version is not installed
     */
    public static final int BASS_ERROR_DX = 39;

    /**
     * connection timed out
     */
    public static final int BASS_ERROR_TIMEOUT = 40;

    /**
     * unsupported file format
     */
    public static final int BASS_ERROR_FILEFORM = 41;

    /**
     * unavailable speaker
     */
    public static final int BASS_ERROR_SPEAKER = 42;

    /**
     * invalid BASS version (used by add-ons)
     */
    public static final int BASS_ERROR_VERSION = 43;

    /**
     * codec is not available/supported
     */
    public static final int BASS_ERROR_CODEC = 44;

    /**
     * the channel/file has ended
     */
    public static final int BASS_ERROR_ENDED = 45;

    /**
     * the device is busy
     */
    public static final int BASS_ERROR_BUSY = 46;

    /**
     * some other mystery problem
     */
    public static final int BASS_ERROR_UNKNOWN = -1;

}
