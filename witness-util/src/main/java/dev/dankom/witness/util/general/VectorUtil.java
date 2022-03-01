package dev.dankom.witness.util.general;

import dev.dankom.math.point.d.Point2D;
import dev.dankom.math.point.d.Point3D;
import dev.dankom.math.point.f.Point2F;
import dev.dankom.math.point.f.Point3F;
import dev.dankom.math.point.i.Point2I;
import dev.dankom.math.point.i.Point3I;

public class VectorUtil {
    public static final Point2F vector(float x, float y) {
        return new Point2F(x, y);
    }

    public static final Point2D vector(double x, double y) {
        return new Point2D(x, y);
    }

    public static final Point2I vector(int x, int y) {
        return new Point2I(x, y);
    }

    public static final Point3F vector(float x, float y, float z) {
        return new Point3F(x, y, z);
    }

    public static final Point3D vector(double x, double y, double z) {
        return new Point3D(x, y, z);
    }

    public static final Point3I vector(int x, int y, int z) {
        return new Point3I(x, y, z);
    }
}
