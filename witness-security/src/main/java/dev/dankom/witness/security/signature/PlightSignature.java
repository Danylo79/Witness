package dev.dankom.witness.security.signature;

import java.security.PrivateKey;

public interface PlightSignature {
    byte[] applySig(String input, PrivateKey key);
}
