package com.github.jbass.constants;

/**
 *
 * @author Maarten
 */
public interface BassSync {

    public static final int BASS_SYNC_POS = 0;
    public static final int BASS_SYNC_END = 2;
    public static final int BASS_SYNC_META = 4;
    public static final int BASS_SYNC_SLIDE = 5;
    public static final int BASS_SYNC_STALL = 6;
    public static final int BASS_SYNC_DOWNLOAD = 7;
    public static final int BASS_SYNC_FREE = 8;
    public static final int BASS_SYNC_SETPOS = 11;
    public static final int BASS_SYNC_MUSICPOS = 10;
    public static final int BASS_SYNC_MUSICINST = 1;
    public static final int BASS_SYNC_MUSICFX = 3;
    public static final int BASS_SYNC_OGG_CHANGE = 12;
    
    /**
     * flag: sync at mixtime, else at playtime
     */
    public static final int BASS_SYNC_MIXTIME = 0x40000000;
    
    /**
     * flag: sync only once, else continuously
     */
    public static final int BASS_SYNC_ONETIME = 0x80000000;
}
