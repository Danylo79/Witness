package dev.dankom.witness.util.general;

import java.util.Date;

public class TimeFormatter {

    private final TimeFormatType tft;
    private final Date time;

    public TimeFormatter(TimeFormatType tft, Date time) {
        this.tft = tft;
        this.time = time;
    }

    public TimeFormatter(TimeFormatType tft, long time) {
        this(tft, new Date(time));
    }

    public TimeFormatter(TimeFormatType tft) {
        this(tft, new Date());
    }

    public String format() {
        String out = "";
        if (tft.equals(TimeFormatType.TWENTY_FOUR_HOUR)) {

        } else {

        }
        return out;
    }

    public enum TimeFormatType {
        TWENTY_FOUR_HOUR, TWELVE_HOUR
    }
}
