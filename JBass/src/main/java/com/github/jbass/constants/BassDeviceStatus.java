package com.github.jbass.constants;

/**
 *
 * @author MBlokker
 */
public interface BassDeviceStatus {

    /**
     * The device is enabled. It will not be possible to initialize the device
     * if this flag is not present.
     */
    public static final int BASS_DEVICE_ENABLED = 1;

    /**
     * The device is the system default.
     */
    public static final int BASS_DEVICE_DEFAULT = 2;

    /**
     * The device is initialized, ie. BASS_Init or BASS_RecordInit has been
     * called.
     */
    public static final int BASS_DEVICE_INIT = 4;

    /**
     * The type of device may also be indicated in the high 8 bits, use this
     * mask to test.
     */
    public static final int BASS_DEVICE_TYPE_MASK = 0xff000000;

    /**
     * An audio endpoint device that the user accesses remotely through a
     * network.
     */
    public static final int BASS_DEVICE_TYPE_NETWORK = 0x01000000;

    /**
     * A set of speakers.
     */
    public static final int BASS_DEVICE_TYPE_SPEAKERS = 0x02000000;

    /**
     * An audio endpoint device that sends a line-level analog signal to a
     * line-input jack on an audio adapter or that receives a line-level analog
     * signal from a line-output jack on the adapter.
     */
    public static final int BASS_DEVICE_TYPE_LINE = 0x03000000;

    /**
     * A set of headphones.
     */
    public static final int BASS_DEVICE_TYPE_HEADPHONES = 0x04000000;

    /**
     * A microphone.
     */
    public static final int BASS_DEVICE_TYPE_MICROPHONE = 0x05000000;

    /**
     * An earphone or a pair of earphones with an attached mouthpiece for
     * two-way communication.
     */
    public static final int BASS_DEVICE_TYPE_HEADSET = 0x06000000;

    /**
     * The part of a telephone that is held in the hand and that contains a
     * speaker and a microphone for two-way communication.
     */
    public static final int BASS_DEVICE_TYPE_HANDSET = 0x07000000;

    /**
     * An audio endpoint device that connects to an audio adapter through a
     * connector for a digital interface of unknown type.
     */
    public static final int BASS_DEVICE_TYPE_DIGITAL = 0x08000000;

    /**
     * An audio endpoint device that connects to an audio adapter through a
     * Sony/Philips Digital Interface (S/PDIF) connector.
     */
    public static final int BASS_DEVICE_TYPE_SPDIF = 0x09000000;

    /**
     * An audio endpoint device that connects to an audio adapter through a
     * High-Definition Multimedia Interface (HDMI) connector.
     */
    public static final int BASS_DEVICE_TYPE_HDMI = 0x0a000000;

    /**
     * An audio endpoint device that connects to an audio adapter through a
     * DisplayPort connector.
     */
    public static final int BASS_DEVICE_TYPE_DISPLAYPORT = 0x40000000;

    /**
     * On OSX, the BASS_DEVICES_AIRPLAY flag can be used in the device paramater
     * to enumerate Airplay receivers instead of soundcards. A shared buffer is
     * used for the Airplay receiver name information, which gets overwritten
     * each time Airplay receiver information is requested, so it should be
     * copied if needed. The BASS_CONFIG_AIRPLAY config option can be used to
     * change which of the receiver(s) are used.
     */
    public static final int BASS_DEVICES_AIRPLAY = 0x1000000;
}
