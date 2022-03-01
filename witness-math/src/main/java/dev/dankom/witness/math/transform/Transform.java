package dev.dankom.witness.math.transform;

import dev.dankom.witness.math.interfaces.ITransformable;

public class Transform<T extends ITransformable> implements ITransformable<T> {
    public final T transform;

    public Transform(T transform) {
        this.transform = transform;
    }

    @Override
    public void add(T o) {
        o.add(transform);
    }

    @Override
    public void minus(T o) {
        o.minus(transform);
    }

    @Override
    public void multiply(T o) {
        o.multiply(transform);
    }

    @Override
    public void divide(T o) {
        o.divide(transform);
    }

    public void square(T o) {
        o.multiply(o);
    }
}
