package dev.dankom.witness.util.general;

public class ByteUtil {
    public static byte[] alloc(int capacity) {
        return new byte[capacity];
    }
    
    public static byte[] flip(byte[] bytes) {
        byte[] out = alloc(bytes.length);
        int flippedLoc = out.length - 1;
        for (byte b : bytes) {
            out[flippedLoc] = b;
            flippedLoc--;
        }
        return out;
    }
}
