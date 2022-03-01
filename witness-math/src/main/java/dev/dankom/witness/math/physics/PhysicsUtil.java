package dev.dankom.witness.math.physics;

public class PhysicsUtil {
    public int calcSpeed(int constantFactor, int distance) {
        return constantFactor / distance;
    }

    public int calcSpeed(int constantFactor, int dampingFactor, int distance) {
        return (dampingFactor / distance) ^ (1 / dampingFactor);
    }
}
