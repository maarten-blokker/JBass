package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassVam {

    /**
     * Play the sample in hardware. If no hardware voices are available then the
     * play call will fail.
     */
    public static final int BASS_VAM_HARDWARE = 1;

    /**
     * Play the sample in software (ie. non-accelerated). No other VAM flags may
     * be used together with this flag.
     *
     */
    public static final int BASS_VAM_SOFTWARE = 2;

    /**
     * If there are no free hardware voices, the buffer to be terminated will be
     * the one with the least time left to play.
     */
    public static final int BASS_VAM_TERM_TIME = 4;

    /**
     * If there are no free hardware voices, the buffer to be terminated will be
     * one that was loaded/created with the BASS_SAMPLE_MUTEMAX flag and is
     * beyond its max distance (maxdist). If there are no buffers that match
     * this criteria, then the play call will fail.
     */
    public static final int BASS_VAM_TERM_DIST = 8;

    /**
     * If there are no free hardware voices, the buffer to be terminated will be
     * the one with the lowest priority. This flag may be used with the
     * TERM_TIME or TERM_DIST flag, if multiple voices have the same priority
     * then the time or distance is used to decide which to terminate.
     */
    public static final int BASS_VAM_TERM_PRIO = 16;
}
