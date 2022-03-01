package dev.dankom.witness.math.point.i;

import dev.dankom.witness.math.interfaces.IPoint3;

public class Point3I implements IPoint3<Integer, Point3I> {
    private int x;
    private int y;
    private int z;

    public Point3I(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public void add(Point3I poi) {
        x += poi.getX();
        y += poi.getY();
        z += poi.getZ();
    }

    public void minus(Point3I poi) {
        x -= poi.getX();
        y -= poi.getY();
        z -= poi.getZ();
    }

    public void multiply(Point3I poi) {
        x *= poi.getX();
        y *= poi.getY();
        z *= poi.getZ();
    }

    public void divide(Point3I poi) {
        x /= poi.getX();
        y /= poi.getY();
        z /= poi.getZ();
    }
}
