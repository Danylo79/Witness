package dev.dankom.witness.math.interfaces;

public interface IPoint3<T, V> extends ITransformable<V>, IPoint2<T, V> {
    T getX();
    T getY();
    T getZ();
}
