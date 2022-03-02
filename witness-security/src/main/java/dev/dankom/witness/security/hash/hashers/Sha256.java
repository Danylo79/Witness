package dev.dankom.witness.security.hash.hashers;

import dev.dankom.witness.security.hash.Hasher;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Sha256 implements Hasher {
    @Override
    public String hash(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
