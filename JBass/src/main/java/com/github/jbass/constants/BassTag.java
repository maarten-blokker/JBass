package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassTag {

    /**
     * ID3v1 tags : TAG_ID3 structure
     */
    public static final int BASS_TAG_ID3 = 0;

    /**
     * ID3v2 tags : variable length block
     */
    public static final int BASS_TAG_ID3V2 = 1;

    /**
     * OGG comments : series of null-terminated UTF-8 strings
     */
    public static final int BASS_TAG_OGG = 2;

    /**
     * HTTP headers : series of null-terminated ANSI strings
     */
    public static final int BASS_TAG_HTTP = 3;

    /**
     * ICY headers : series of null-terminated ANSI strings
     */
    public static final int BASS_TAG_ICY = 4;

    /**
     * ICY metadata : ANSI string
     */
    public static final int BASS_TAG_META = 5;

    /**
     * APE tags : series of null-terminated UTF-8 strings
     */
    public static final int BASS_TAG_APE = 6;

    /**
     * MP4/iTunes metadata : series of null-terminated UTF-8 strings
     */
    public static final int BASS_TAG_MP4 = 7;

    /**
     * WMA tags : series of null-terminated UTF-8 strings
     */
    public static final int BASS_TAG_WMA = 8;

    /**
     * OGG encoder : UTF-8 string
     */
    public static final int BASS_TAG_VENDOR = 9;

    /**
     * Lyric3v2 tag : ASCII string
     */
    public static final int BASS_TAG_LYRICS3 = 10;

    /**
     * CoreAudio codec info : TAG_CA_CODEC structure
     */
    public static final int BASS_TAG_CA_CODEC = 11;

    /**
     * Media Foundation tags : series of null-terminated UTF-8 strings
     */
    public static final int BASS_TAG_MF = 13;

    /**
     * WAVE format : WAVEFORMATEEX structure
     */
    public static final int BASS_TAG_WAVEFORMAT = 14;

    /**
     * RIFF "INFO" tags : series of null-terminated ANSI strings
     */
    public static final int BASS_TAG_RIFF_INFO = 0x100;

    /**
     * RIFF/BWF "bext" tags : TAG_BEXT structure
     */
    public static final int BASS_TAG_RIFF_BEXT = 0x101;

    /**
     * RIFF/BWF "cart" tags : TAG_CART structure
     */
    public static final int BASS_TAG_RIFF_CART = 0x102;

    /**
     * RIFF "DISP" text tag : ANSI string
     */
    public static final int BASS_TAG_RIFF_DISP = 0x103;

    /**
     * + index #, binary APE tag : TAG_APE_BINARY structure
     */
    public static final int BASS_TAG_APE_BINARY = 0x1000;

    /**
     * MOD music name : ANSI string
     */
    public static final int BASS_TAG_MUSIC_NAME = 0x10000;

    /**
     * MOD message : ANSI string
     */
    public static final int BASS_TAG_MUSIC_MESSAGE = 0x10001;

    /**
     * MOD order list : BYTE array of pattern numbers
     */
    public static final int BASS_TAG_MUSIC_ORDERS = 0x10002;

    /**
     * MOD author : UTF-8 string
     */
    public static final int BASS_TAG_MUSIC_AUTH = 0x10003;

    /**
     * + instrument #, MOD instrument name : ANSI string
     */
    public static final int BASS_TAG_MUSIC_INST = 0x10100;

    /**
     * + sample #, MOD sample name : ANSI string
     */
    public static final int BASS_TAG_MUSIC_SAMPLE = 0x10300;
}
