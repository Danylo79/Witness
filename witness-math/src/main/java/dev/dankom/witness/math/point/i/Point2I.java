package dev.dankom.witness.math.point.i;

import dev.dankom.witness.math.interfaces.IPoint2;

public class Point2I implements IPoint2<Integer, Point2I> {
    private int x;
    private int y;

    public Point2I(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void add(Point2I poi) {
        x += poi.getX();
        y += poi.getY();
    }

    public void minus(Point2I poi) {
        x -= poi.getX();
        y -= poi.getY();
    }

    public void multiply(Point2I poi) {
        x *= poi.getX();
        y *= poi.getY();
    }

    public void divide(Point2I poi) {
        x /= poi.getX();
        y /= poi.getY();
    }
}
