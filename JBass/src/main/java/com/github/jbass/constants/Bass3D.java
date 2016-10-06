package com.github.jbass.constants;

/**
 *
 * @author Maarten
 */
public interface Bass3D {

    /**
     * normal 3D processing
     */
    public static final int BASS_3DMODE_NORMAL = 0;
    /**
     * position is relative to the listener
     */
    public static final int BASS_3DMODE_RELATIVE = 1;
    /**
     * no 3D processing
     */
    public static final int BASS_3DMODE_OFF = 2;
    
    
    public static final int BASS_3DALG_DEFAULT = 0;
    public static final int BASS_3DALG_OFF = 1;
    public static final int BASS_3DALG_FULL = 2;
    public static final int BASS_3DALG_LIGHT = 3;
}
