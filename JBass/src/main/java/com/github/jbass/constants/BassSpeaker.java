package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassSpeaker {

    /**
     * front speakers
     */
    public static final int BASS_SPEAKER_FRONT = 0x1000000;
    /**
     * rear/side speakers
     */
    public static final int BASS_SPEAKER_REAR = 0x2000000;
    /**
     * center & LFE speakers (5.1)
     */
    public static final int BASS_SPEAKER_CENLFE = 0x3000000;
    /**
     * rear center speakers (7.1)
     */
    public static final int BASS_SPEAKER_REAR2 = 0x4000000;
    /**
     * modifier: left
     */
    public static final int BASS_SPEAKER_LEFT = 0x10000000;
    /**
     * modifier: right
     */
    public static final int BASS_SPEAKER_RIGHT = 0x20000000;

    public static final int BASS_SPEAKER_FRONTLEFT = BASS_SPEAKER_FRONT | BASS_SPEAKER_LEFT;
    public static final int BASS_SPEAKER_FRONTRIGHT = BASS_SPEAKER_FRONT | BASS_SPEAKER_RIGHT;
    public static final int BASS_SPEAKER_REARLEFT = BASS_SPEAKER_REAR | BASS_SPEAKER_LEFT;
    public static final int BASS_SPEAKER_REARRIGHT = BASS_SPEAKER_REAR | BASS_SPEAKER_RIGHT;
    public static final int BASS_SPEAKER_CENTER = BASS_SPEAKER_CENLFE | BASS_SPEAKER_LEFT;
    public static final int BASS_SPEAKER_LFE = BASS_SPEAKER_CENLFE | BASS_SPEAKER_RIGHT;
    public static final int BASS_SPEAKER_REAR2LEFT = BASS_SPEAKER_REAR2 | BASS_SPEAKER_LEFT;
    public static final int BASS_SPEAKER_REAR2RIGHT = BASS_SPEAKER_REAR2 | BASS_SPEAKER_RIGHT;
    
}
