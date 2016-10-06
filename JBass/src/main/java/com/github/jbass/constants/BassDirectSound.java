package com.github.jbass.constants;

/**
 * BASS_INFO flags (from DSOUND.H)

 * @author MBlokker
 */
public interface BassDirectSound {

    /**
     * supports all sample rates between min/maxrate
     */
    public static final int DSCAPS_CONTINUOUSRATE = 0x00000010;
    
    /**
     * device does NOT have hardware DirectSound support
     */
    public static final int DSCAPS_EMULDRIVER = 0x00000020;
    
    /**
     * device driver has been certified by Microsoft
     */
    public static final int DSCAPS_CERTIFIED = 0x00000040;
    
    /**
     * mono
     */
    public static final int DSCAPS_SECONDARYMONO = 0x00000100;
    
    /**
     * stereo
     */
    public static final int DSCAPS_SECONDARYSTEREO = 0x00000200;
    
    /**
     * 8 bit
     */
    public static final int DSCAPS_SECONDARY8BIT = 0x00000400;
    
    /**
     * 16 bit
     */
    public static final int DSCAPS_SECONDARY16BIT = 0x00000800;
    
    /**
     * device does NOT have hardware DirectSound recording support
     */
    public static final int DSCCAPS_EMULDRIVER = DSCAPS_EMULDRIVER;
    
    /**
     * device driver has been certified by Microsoft
     */
    public static final int DSCCAPS_CERTIFIED = DSCAPS_CERTIFIED;
    
}
