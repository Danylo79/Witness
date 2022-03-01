package dev.dankom.witness.math.point.f;

import dev.dankom.witness.math.interfaces.IPoint2;

public class Point2F implements IPoint2<Float, Point2F> {
    private float x;
    private float y;

    public Point2F(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public void add(Point2F poi) {
        x += poi.getX();
        y += poi.getY();
    }

    public void minus(Point2F poi) {
        x -= poi.getX();
        y -= poi.getY();
    }

    public void multiply(Point2F poi) {
        x *= poi.getX();
        y *= poi.getY();
    }

    public void divide(Point2F poi) {
        x /= poi.getX();
        y /= poi.getY();
    }
}
