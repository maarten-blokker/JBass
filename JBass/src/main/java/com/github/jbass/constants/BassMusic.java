package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassMusic {

    public static final int BASS_MUSIC_FLOAT = BassSample.BASS_SAMPLE_FLOAT;
    public static final int BASS_MUSIC_MONO = BassSample.BASS_SAMPLE_MONO;
    public static final int BASS_MUSIC_LOOP = BassSample.BASS_SAMPLE_LOOP;
    public static final int BASS_MUSIC_3D = BassSample.BASS_SAMPLE_3D;
    public static final int BASS_MUSIC_FX = BassSample.BASS_SAMPLE_FX;
    public static final int BASS_MUSIC_AUTOFREE = BassStream.BASS_STREAM_AUTOFREE;
    public static final int BASS_MUSIC_DECODE = BassStream.BASS_STREAM_DECODE;
    /**
     * calculate playback length
     */
    public static final int BASS_MUSIC_PRESCAN = BassStream.BASS_STREAM_PRESCAN;
    public static final int BASS_MUSIC_CALCLEN = BASS_MUSIC_PRESCAN;
    
    /**
     * normal ramping
     */
    public static final int BASS_MUSIC_RAMP = 0x200;
    
    /**
     * sensitive ramping
     */
    public static final int BASS_MUSIC_RAMPS = 0x400;
    
    /**
     * surround sound
     */
    public static final int BASS_MUSIC_SURROUND = 0x800;
    
    /**
     * surround sound (mode 2)
     */
    public static final int BASS_MUSIC_SURROUND2 = 0x1000;
    
    /**
     * apply FastTracker 2 panning to XM files
     */
    public static final int BASS_MUSIC_FT2PAN = 0x2000;
    
    /**
     * play .MOD as FastTracker 2 does
     */
    public static final int BASS_MUSIC_FT2MOD = 0x2000;
    
    /**
     * play .MOD as ProTracker 1 does
     */
    public static final int BASS_MUSIC_PT1MOD = 0x4000;
    
    /**
     * non-interpolated sample mixing
     */
    public static final int BASS_MUSIC_NONINTER = 0x10000;
    
    /**
     * sinc interpolated sample mixing
     */
    public static final int BASS_MUSIC_SINCINTER = 0x800000;
    
    /**
     * stop all notes when moving position
     */
    public static final int BASS_MUSIC_POSRESET = 0x8000;
    
    /**
     * stop all notes and reset bmp/etc when moving position
     */
    public static final int BASS_MUSIC_POSRESETEX = 0x400000;
    
    /**
     * stop the music on a backwards jump effect
     */
    public static final int BASS_MUSIC_STOPBACK = 0x80000;
    
    /**
     * don't load the samples
     */
    public static final int BASS_MUSIC_NOSAMPLE = 0x100000;
}
