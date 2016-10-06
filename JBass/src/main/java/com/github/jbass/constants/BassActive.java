package com.github.jbass.constants;

/**
 * BASS_ChannelIsActive return values.
 *
 * @author Maarten
 */
public interface BassActive {

    /**
     * The channel is not active, or handle is not a valid channel.
     */
    public static final int BASS_ACTIVE_STOPPED = 0;

    /**
     * The channel is playing (or recording).
     */
    public static final int BASS_ACTIVE_PLAYING = 1;

    /**
     * Playback of the stream has been stalled due to a lack of sample data. The
     * playback will automatically resume once there is sufficient data to do
     * so.
     */
    public static final int BASS_ACTIVE_STALLED = 2;

    /**
     * The channel is paused.
     */
    public static final int BASS_ACTIVE_PAUSED = 3;
}
