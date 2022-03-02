package dev.dankom.witness.security.signature;

import java.security.PrivateKey;

public interface WitnessSignature {
    byte[] applySig(String input, PrivateKey key);
}
