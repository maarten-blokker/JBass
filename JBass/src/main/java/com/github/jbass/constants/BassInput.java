package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassInput {

    public static final int BASS_INPUT_OFF = 0x10000;
    public static final int BASS_INPUT_ON = 0x20000;
    public static final int BASS_INPUT_TYPE_MASK = 0xff000000;
    public static final int BASS_INPUT_TYPE_UNDEF = 0x00000000;
    public static final int BASS_INPUT_TYPE_DIGITAL = 0x01000000;
    public static final int BASS_INPUT_TYPE_LINE = 0x02000000;
    public static final int BASS_INPUT_TYPE_MIC = 0x03000000;
    public static final int BASS_INPUT_TYPE_SYNTH = 0x04000000;
    public static final int BASS_INPUT_TYPE_CD = 0x05000000;
    public static final int BASS_INPUT_TYPE_PHONE = 0x06000000;
    public static final int BASS_INPUT_TYPE_SPEAKER = 0x07000000;
    public static final int BASS_INPUT_TYPE_WAVE = 0x08000000;
    public static final int BASS_INPUT_TYPE_AUX = 0x09000000;
    public static final int BASS_INPUT_TYPE_ANALOG = 0x0a000000;
}
