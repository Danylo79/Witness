package dev.dankom.witness.util.general;

import dev.dankom.util.general.ExceptionUtil;

public class Validation {
    public static void notNull(String msg, Object object) {
        if (object == null) {
            ExceptionUtil.throwException(msg);
        }
    }

    public static void assertObject(String msg, Object o, Object o1) {
        if (o != o1) {
            ExceptionUtil.throwException(msg);
        }
    }
}
