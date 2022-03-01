package dev.dankom.witness.math.box;

import dev.dankom.witness.math.interfaces.ITransformable;

public class BoundingBox3F implements ITransformable<BoundingBox3F> {
    private float x;
    private float y;
    private float z;
    private final float width;
    private final float height;
    private final float depth;

    public BoundingBox3F(float x, float y, float z, float width, float height, float depth) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public boolean inBounds(float x, float y, float z) {
        boolean isInX = this.x < x && x < (this.x + width);
        boolean isInY = this.y < y && y > (this.y - height);
        boolean isInZ = this.z < z && z < (this.z + depth);
        return isInX && isInY && isInZ;
    }

    @Override
    public void add(BoundingBox3F o) {
        x += o.x;
        y += o.y;
        z += o.z;
    }

    @Override
    public void minus(BoundingBox3F o) {
        x -= o.x;
        y -= o.y;
        z -= o.z;
    }

    @Override
    public void multiply(BoundingBox3F o) {
        x *= o.x;
        y *= o.y;
        z *= o.z;
    }

    @Override
    public void divide(BoundingBox3F o) {
        x /= o.x;
        y /= o.y;
        z /= o.z;
    }
}
