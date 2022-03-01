package dev.dankom.witness.util.general;

import java.util.UUID;
import java.util.regex.Pattern;

public class UUIDUtil {
    public static UUID uuidFromString(String s) {
        if (s.contains("-")) {
            return UUID.fromString(s);
        } else {
            return UUID.fromString(addDashesToUUID(s));
        }
    }

    public static String addDashesToUUID(String s) {
        if (s == null) throw new IllegalArgumentException();
        StringBuilder builder = new StringBuilder(s.trim());
        /* Backwards adding to avoid index adjustments */
        try {
            builder.insert(20, "-");
            builder.insert(16, "-");
            builder.insert(12, "-");
            builder.insert(8, "-");
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return builder.toString();
    }

    public boolean isUUID(String s) {
        return Pattern.compile("^(?<data1>[0-9a-fA-F]{8})-(?<data2>[0-9a-fA-F]{4})-(?<data3>[0-9a-fA-F]{4})-(?<data4>[0-9a-fA-F]{4})-(?<data5>[0-9a-fA-F]{12})$").matcher(s).find();
    }
}