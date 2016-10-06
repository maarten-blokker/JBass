package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassStream {

    /**
     * enable pin-point seeking/length (MP3/MP2/MP1)
     */
    public static final int BASS_STREAM_PRESCAN = 0x20000;
    public static final int BASS_MP3_SETPOS = BASS_STREAM_PRESCAN;

    /**
     * automatically free the stream when it stop/ends
     */
    public static final int BASS_STREAM_AUTOFREE = 0x40000;

    /**
     * restrict the download rate of internet file streams
     */
    public static final int BASS_STREAM_RESTRATE = 0x80000;

    /**
     * download/play internet file stream in small blocks
     */
    public static final int BASS_STREAM_BLOCK = 0x100000;

    /**
     * don't play the stream, only decode (BASS_ChannelGetData)
     */
    public static final int BASS_STREAM_DECODE = 0x200000;

    /**
     * give server status info (HTTP/ICY tags) in DOWNLOADPROC
     */
    public static final int BASS_STREAM_STATUS = 0x800000;

    /**
     * end of user stream flag, used to signify the end of the stream.
     */
    public static final int BASS_STREAMPROC_END = 0x80000000;   

}
