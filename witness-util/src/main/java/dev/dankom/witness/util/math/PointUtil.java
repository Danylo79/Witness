package dev.dankom.witness.util.math;

import dev.dankom.math.interfaces.IPoint2;
import dev.dankom.math.interfaces.IPoint3;
import dev.dankom.math.point.d.Point2D;
import dev.dankom.math.point.d.Point3D;
import dev.dankom.math.point.f.Point2F;
import dev.dankom.math.point.f.Point3F;
import dev.dankom.math.point.i.Point2I;
import dev.dankom.math.point.i.Point3I;
import dev.dankom.util.general.ObjectUtil;

public class PointUtil {
    public static Point3I toPoint3I(IPoint3 point) {
        return new Point3I(ObjectUtil.number(point.getX()), ObjectUtil.number(point.getY()), ObjectUtil.number(point.getZ()));
    }

    public static Point3D toPoint3D(IPoint3 point) {
        return new Point3D(ObjectUtil.number(point.getX()), ObjectUtil.number(point.getY()), ObjectUtil.number(point.getZ()));
    }

    public static Point3F toPoint3F(IPoint3 point) {
        return new Point3F(ObjectUtil.number(point.getX()), ObjectUtil.number(point.getY()), ObjectUtil.number(point.getZ()));
    }

    public static Point2I toPoint2I(IPoint2 point) {
        return new Point2I(ObjectUtil.number(point.getX()), ObjectUtil.number(point.getY()));
    }

    public static Point2D toPoint2D(IPoint2 point) {
        return new Point2D(ObjectUtil.number(point.getX()), ObjectUtil.number(point.getY()));
    }

    public static Point2F toPoint2F(IPoint2 point) {
        return new Point2F(ObjectUtil.number(point.getX()), ObjectUtil.number(point.getY()));
    }
}
