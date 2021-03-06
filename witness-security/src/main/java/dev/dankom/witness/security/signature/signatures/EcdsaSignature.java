package dev.dankom.witness.security.signature.signatures;

import dev.dankom.witness.security.signature.WitnessSignature;

import java.security.PrivateKey;
import java.security.Signature;

public class EcdsaSignature implements WitnessSignature {
    @Override
    public byte[] applySig(String input, PrivateKey key) {
        Signature dsa;
        byte[] output;
        try {
            dsa = Signature.getInstance("ECDSA", "BC");
            dsa.initSign(key);
            byte[] strByte = input.getBytes();
            dsa.update(strByte);
            byte[] realSig = dsa.sign();
            output = realSig;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return output;
    }
}
