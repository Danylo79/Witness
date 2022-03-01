package dev.dankom.witness.math.vector;

import dev.dankom.witness.math.interfaces.IPoint3;
import dev.dankom.witness.math.interfaces.ITransformable;
import dev.dankom.witness.math.point.f.Point3F;
import dev.dankom.witness.math.rotator.Rotator;

public class Vector implements ITransformable<Vector> {
    private final Point3F start;
    private final Rotator rotator;
    private float length;

    public Vector(IPoint3 start, Rotator rotator, float length) {
        this.start = new Point3F((float) start.getX(), (float) start.getY(), (float) start.getZ());
        this.rotator = rotator;
        this.length = length;
    }

    public Point3F getStart() {
        return start;
    }

    public Rotator getRotator() {
        return rotator;
    }

    public float getLength() {
        return length;
    }

    @Override
    public void add(Vector o) {
        start.add(o.start);
        rotator.add(o.rotator);
        length += o.length;
    }

    @Override
    public void minus(Vector o) {
        start.minus(o.start);
        rotator.minus(o.rotator);
        length -= o.length;
    }

    @Override
    public void multiply(Vector o) {
        start.multiply(o.start);
        rotator.multiply(o.rotator);
        length *= o.length;
    }

    @Override
    public void divide(Vector o) {
        start.divide(o.start);
        rotator.divide(o.rotator);
        length /= o.length;
    }
}
