package dev.dankom.witness.math.point.f;

import dev.dankom.witness.math.interfaces.IPoint3;

public class Point3F implements IPoint3<Float, Point3F> {
    private float x;
    private float y;
    private float z;

    public Point3F(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public Float getZ() {
        return z;
    }

    public void add(Point3F poi) {
        x += poi.getX();
        y += poi.getY();
        z += poi.getZ();
    }

    public void minus(Point3F poi) {
        x -= poi.getX();
        y -= poi.getY();
        z -= poi.getZ();
    }

    public void multiply(Point3F poi) {
        x *= poi.getX();
        y *= poi.getY();
        z *= poi.getZ();
    }

    public void divide(Point3F poi) {
        x /= poi.getX();
        y /= poi.getY();
        z /= poi.getZ();
    }
}
