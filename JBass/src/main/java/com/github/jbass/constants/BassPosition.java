package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassPosition {

    /**
     * byte position
     */
    public static final int BASS_POS_BYTE = 0;
    
    /**
     * order.row position, MAKELONG(order,row)
     */
    public static final int BASS_POS_MUSIC_ORDER = 1;
    
    /**
     * OGG bitstream number
     */
    public static final int BASS_POS_OGG = 3;
    
    /**
     * flag: allow seeking to inexact position
     */
    public static final int BASS_POS_INEXACT = 0x8000000;
    
    /**
     * flag: get the decoding (not playing) position
     */
    public static final int BASS_POS_DECODE = 0x10000000;
    
    /**
     * flag: decode to the position instead of seeking
     */
    public static final int BASS_POS_DECODETO = 0x20000000;
    
    /**
     * flag: scan to the position
     */
    public static final int BASS_POS_SCAN = 0x40000000;
}
