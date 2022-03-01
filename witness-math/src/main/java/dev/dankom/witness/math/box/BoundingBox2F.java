package dev.dankom.witness.math.box;

import dev.dankom.witness.math.interfaces.ITransformable;

public class BoundingBox2F implements ITransformable<BoundingBox2F> {
    private float x;
    private float y;
    private final float width;
    private final float height;

    public BoundingBox2F(float x, float y, float width, float height) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public boolean inBounds(float x, float y) {
        boolean isInX = this.x < x && x < (this.x + width);
        boolean isInY = this.y < y && y > (this.y - height);
        return isInX && isInY;
    }

    @Override
    public void add(BoundingBox2F o) {
        x += o.x;
        y += o.y;
    }

    @Override
    public void minus(BoundingBox2F o) {
        x -= o.x;
        y -= o.y;
    }

    @Override
    public void multiply(BoundingBox2F o) {
        x *= o.x;
        y *= o.y;
    }

    @Override
    public void divide(BoundingBox2F o) {
        x /= o.x;
        y /= o.y;
    }
}
