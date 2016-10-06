package com.github.jbass.constants;

/**
 *
 * @author Maarten
 */
public interface BassAttributes {

    public static final int BASS_ATTRIB_FREQ = 1;
    public static final int BASS_ATTRIB_VOL = 2;
    public static final int BASS_ATTRIB_PAN = 3;
    public static final int BASS_ATTRIB_EAXMIX = 4;
    public static final int BASS_ATTRIB_NOBUFFER = 5;
    public static final int BASS_ATTRIB_VBR = 6;
    public static final int BASS_ATTRIB_CPU = 7;
    public static final int BASS_ATTRIB_SRC = 8;
    public static final int BASS_ATTRIB_NET_RESUME = 9;
    public static final int BASS_ATTRIB_SCANINFO = 10;
    public static final int BASS_ATTRIB_NORAMP = 11;
    public static final int BASS_ATTRIB_BITRATE = 12;
    public static final int BASS_ATTRIB_MUSIC_AMPLIFY = 0x100;
    public static final int BASS_ATTRIB_MUSIC_PANSEP = 0x101;
    public static final int BASS_ATTRIB_MUSIC_PSCALER = 0x102;
    public static final int BASS_ATTRIB_MUSIC_BPM = 0x103;
    public static final int BASS_ATTRIB_MUSIC_SPEED = 0x104;
    public static final int BASS_ATTRIB_MUSIC_VOL_GLOBAL = 0x105;
    public static final int BASS_ATTRIB_MUSIC_ACTIVE = 0x106;

    /**
     * + channel #
     */
    public static final int BASS_ATTRIB_MUSIC_VOL_CHAN = 0x200;

    /**
     * + instrument #
     */
    public static final int BASS_ATTRIB_MUSIC_VOL_INST = 0x300;
}
