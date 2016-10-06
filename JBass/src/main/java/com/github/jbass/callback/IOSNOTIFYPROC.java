package com.github.jbass.callback;

/**
 * iOS notification callback.
 *
 * @author Maarten
 */
public interface IOSNOTIFYPROC {

    /**
     * interruption started
     */
    public static final int BASS_IOSNOTIFY_INTERRUPT = 1;

    /**
     * interruption ended
     */
    public static final int BASS_IOSNOTIFY_INTERRUPT_END = 2;

    /**
     * 
     * @param status The notification (BASS_IOSNOTIFY_xxx)
     */
    public void onIOSInterupt(int status);

}
