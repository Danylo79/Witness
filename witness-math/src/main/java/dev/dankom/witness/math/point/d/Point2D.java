package dev.dankom.witness.math.point.d;

import dev.dankom.witness.math.interfaces.IPoint2;

public class Point2D implements IPoint2<Double, Point2D> {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void add(Point2D poi) {
        x += poi.getX();
        y += poi.getY();
    }

    public void minus(Point2D poi) {
        x -= poi.getX();
        y -= poi.getY();
    }

    public void multiply(Point2D poi) {
        x *= poi.getX();
        y *= poi.getY();
    }

    public void divide(Point2D poi) {
        x /= poi.getX();
        y /= poi.getY();
    }
}
