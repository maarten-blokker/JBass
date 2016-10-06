package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassCType {

    /**
     * Sample channel.
     */
    public static final int BASS_CTYPE_SAMPLE = 1;

    /**
     * Recording channel.
     */
    public static final int BASS_CTYPE_RECORD = 2;

    /**
     * User sample stream.
     */
    public static final int BASS_CTYPE_STREAM = 0x10000;

    /**
     * Ogg Vorbis format stream.
     */
    public static final int BASS_CTYPE_STREAM_OGG = 0x10002;

    /**
     * MPEG layer 1 format stream.
     */
    public static final int BASS_CTYPE_STREAM_MP1 = 0x10003;

    /**
     * MPEG layer 2 format stream.
     */
    public static final int BASS_CTYPE_STREAM_MP2 = 0x10004;

    /**
     * MPEG layer 3 format stream.
     */
    public static final int BASS_CTYPE_STREAM_MP3 = 0x10005;

    /**
     * Audio IFF format stream.
     */
    public static final int BASS_CTYPE_STREAM_AIFF = 0x10006;

    /**
     * CoreAudio codec stream. Additional format information is avaliable from
     * BASS_ChannelGetTags (BASS_TAG_CA_CODEC).
     */
    public static final int BASS_CTYPE_STREAM_CA = 0x10007;

    /**
     * Media Foundation codec stream. Additional format information is avaliable
     * from BASS_ChannelGetTags (BASS_TAG_WAVEFORMAT).
     */
    public static final int BASS_CTYPE_STREAM_MF = 0x10008;

    /**
     * WAVE format flag. This can be used to test if the channel is any kind of
     * WAVE format. The codec (the file's "wFormatTag") is specified in the
     * LOWORD. Additional information is also avaliable from BASS_ChannelGetTags
     * (BASS_TAG_WAVEFORMAT).
     */
    public static final int BASS_CTYPE_STREAM_WAV = 0x40000;

    /**
     * Integer PCM WAVE format stream.
     */
    public static final int BASS_CTYPE_STREAM_WAV_PCM = 0x50001;

    /**
     * Floating-point PCM WAVE format stream.
     */
    public static final int BASS_CTYPE_STREAM_WAV_FLOAT = 0x50003;

    /**
     * Generic MOD format music.
     */
    public static final int BASS_CTYPE_MUSIC_MOD = 0x20000;

    /**
     * MultiTracker format music.
     */
    public static final int BASS_CTYPE_MUSIC_MTM = 0x20001;

    /**
     * ScreamTracker 3 format music.
     */
    public static final int BASS_CTYPE_MUSIC_S3M = 0x20002;

    /**
     * FastTracker 2 format music.
     */
    public static final int BASS_CTYPE_MUSIC_XM = 0x20003;

    /**
     * Impulse Tracker format music.
     */
    public static final int BASS_CTYPE_MUSIC_IT = 0x20004;
    
    /**
     * MO3 format flag, used in combination with one of the BASS_CTYPE_MUSIC
     * types.
     */
    public static final int BASS_CTYPE_MUSIC_MO3 = 0x00100;
}
