package dev.dankom.witness.math.point.d;

import dev.dankom.witness.math.interfaces.IPoint3;

public class Point3D implements IPoint3<Double, Point3D> {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    public void add(Point3D poi) {
        x += poi.getX();
        y += poi.getY();
        z += poi.getZ();
    }

    public void minus(Point3D poi) {
        x -= poi.getX();
        y -= poi.getY();
        z -= poi.getZ();
    }

    public void multiply(Point3D poi) {
        x *= poi.getX();
        y *= poi.getY();
        z *= poi.getZ();
    }

    public void divide(Point3D poi) {
        x /= poi.getX();
        y /= poi.getY();
        z /= poi.getZ();
    }
}
