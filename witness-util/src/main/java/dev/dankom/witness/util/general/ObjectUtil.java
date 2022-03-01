package dev.dankom.witness.util.general;

public class ObjectUtil {
    public static Integer number(Object o) {
        int out = -1;
        if (o instanceof Float) {
            out = ((Float) o).intValue();
        } else if (o instanceof Double) {
            out = ((Double) o).intValue();
        } else if (o instanceof Integer) {
            out = (int) o;
        }
        return out;
    }
}
