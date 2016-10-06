package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassData {

    /**
     * query how much data is buffered
     */
    public static final int BASS_DATA_AVAILABLE = 0;

    /**
     * flag: return 8.24 fixed-point data
     */
    public static final int BASS_DATA_FIXED = 0x20000000;

    /**
     * flag: return floating-point sample data
     */
    public static final int BASS_DATA_FLOAT = 0x40000000;

    /**
     * 256 sample FFT
     */
    public static final int BASS_DATA_FFT256 = 0x80000000;

    /**
     * 512 FFT
     */
    public static final int BASS_DATA_FFT512 = 0x80000001;

    /**
     * 1024 FFT
     */
    public static final int BASS_DATA_FFT1024 = 0x80000002;

    /**
     * 2048 FFT
     */
    public static final int BASS_DATA_FFT2048 = 0x80000003;

    /**
     * 4096 FFT
     */
    public static final int BASS_DATA_FFT4096 = 0x80000004;

    /**
     * 8192 FFT
     */
    public static final int BASS_DATA_FFT8192 = 0x80000005;

    /**
     * 16384 FFT
     */
    public static final int BASS_DATA_FFT16384 = 0x80000006;

    /**
     * 32768 FFT
     */
    public static final int BASS_DATA_FFT32768 = 0x80000007;

    /**
     * FFT flag: FFT for each channel, else all combined
     */
    public static final int BASS_DATA_FFT_INDIVIDUAL = 0x10;

    /**
     * FFT flag: no Hanning window
     */
    public static final int BASS_DATA_FFT_NOWINDOW = 0x20;

    /**
     * FFT flag: pre-remove DC bias
     */
    public static final int BASS_DATA_FFT_REMOVEDC = 0x40;

    /**
     * FFT flag: return complex data
     */
    public static final int BASS_DATA_FFT_COMPLEX = 0x80;

    /**
     * end & close the file
     */
    public static final int BASS_FILEDATA_END = 0;

}
