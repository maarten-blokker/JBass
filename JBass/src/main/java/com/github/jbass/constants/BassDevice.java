package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassDevice {

    /**
     * 8 bit
     */
    public static final int BASS_DEVICE_8BITS = 1;
    
    /**
     * mono
     */
    public static final int BASS_DEVICE_MONO = 2;
    
    /**
     * enable 3D functionality
     */
    public static final int BASS_DEVICE_3D = 4;
    
    /**
     * limit output to 16 bit
     */
    public static final int BASS_DEVICE_16BITS = 8;
    
    /**
     * calculate device latency (BASS_INFO struct)
     */
    public static final int BASS_DEVICE_LATENCY = 0x100;
    
    /**
     * detect speakers via Windows control panel
     */
    public static final int BASS_DEVICE_CPSPEAKERS = 0x400;
    
    /**
     * force enabling of speaker assignment
     */
    public static final int BASS_DEVICE_SPEAKERS = 0x800;
    
    /**
     * ignore speaker arrangement
     */
    public static final int BASS_DEVICE_NOSPEAKER = 0x1000;
    
    /**
     * use ALSA "dmix" plugin
     */
    public static final int BASS_DEVICE_DMIX = 0x2000;
    
    /**
     * set device sample rate
     */
    public static final int BASS_DEVICE_FREQ = 0x4000;
    
    /**
     * limit output to stereo
     */
    public static final int BASS_DEVICE_STEREO = 0x8000;
    
    /**
     * IDirectSound
     */
    public static final int BASS_OBJECT_DS = 1;
    
    /**
     * IDirectSound3DListener
     */
    public static final int BASS_OBJECT_DS3DL = 2;
}
