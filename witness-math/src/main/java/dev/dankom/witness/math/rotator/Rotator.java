package dev.dankom.witness.math.rotator;

import dev.dankom.witness.math.interfaces.ITransformable;

public class Rotator implements ITransformable<Rotator> {
    private float yaw;
    private float pitch;

    public Rotator(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void add(Rotator rotator) {
        yaw += rotator.yaw;
        pitch += rotator.pitch;
    }

    public void minus(Rotator rotator) {
        yaw -= rotator.yaw;
        pitch -= rotator.pitch;
    }

    public void multiply(Rotator rotator) {
        yaw *= rotator.yaw;
        pitch *= rotator.pitch;
    }

    public void divide(Rotator rotator) {
        yaw /= rotator.yaw;
        pitch /= rotator.pitch;
    }
}
