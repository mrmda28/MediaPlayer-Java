package com.mrmda28.mediaplayer.Helpers;

import java.time.Duration;

public class Helper {
    public static String getFormattedTime(int time) {
        Duration duration = Duration.ofMillis(time);
        long HH = duration.toHours();
        long MM = duration.toMinutesPart();
        long SS = duration.toSecondsPart();
        if (HH > 0) {
            return String.format("%02d:%02d:%02d", HH, MM, SS);
        } else {
            return String.format("%02d:%02d", MM, SS);
        }
    }
}
