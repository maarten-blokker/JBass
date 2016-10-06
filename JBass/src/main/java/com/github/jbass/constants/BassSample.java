package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassSample {

    /**
     * 8 bit
     */
    public static final int BASS_SAMPLE_8BITS = 1;
    
    /**
     * 32 bit floating-point
     */
    public static final int BASS_SAMPLE_FLOAT = 256;
    
    /**
     * mono
     */
    public static final int BASS_SAMPLE_MONO = 2;
    
    /**
     * looped
     */
    public static final int BASS_SAMPLE_LOOP = 4;
    
    /**
     * 3D functionality
     */
    public static final int BASS_SAMPLE_3D = 8;
    
    /**
     * not using hardware mixing
     */
    public static final int BASS_SAMPLE_SOFTWARE = 16;
    
    /**
     * mute at max distance (3D only)
     */
    public static final int BASS_SAMPLE_MUTEMAX = 32;
    
    /**
     * DX7 voice allocation & management
     */
    public static final int BASS_SAMPLE_VAM = 64;
    
    /**
     * old implementation of DX8 effects
     */
    public static final int BASS_SAMPLE_FX = 128;
    
    /**
     * override lowest volume
     */
    public static final int BASS_SAMPLE_OVER_VOL = 0x10000;
    
    /**
     * override longest playing
     */
    public static final int BASS_SAMPLE_OVER_POS = 0x20000;
    
    /**
     * override furthest from listener (3D only)
     */
    public static final int BASS_SAMPLE_OVER_DIST = 0x30000;
}
