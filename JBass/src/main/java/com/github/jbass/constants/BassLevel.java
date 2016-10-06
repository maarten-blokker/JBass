package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassLevel {

    /**
     * Get a mono level. If neither this or the {@link #BASS_LEVEL_STEREO} flag
     * is used, then a separate level is retrieved for each channel.
     */
    public static final int BASS_LEVEL_MONO = 1;

    /**
     * Get a stereo level. The left level will be from the even channels, and
     * the right level will be from the odd channels. If there are an odd number
     * of channels then the left and right levels will both include all
     * channels.
     */
    public static final int BASS_LEVEL_STEREO = 2;

    /**
     * Get the RMS level. Otherwise the peak level.
     */
    public static final int BASS_LEVEL_RMS = 4;
}
