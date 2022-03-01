package dev.dankom.witness.security.cipher;

public interface ICipher {
    String encrypt(String plainText);
    String decrypt(String plainText);
}
