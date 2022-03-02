package dev.dankom.witness.math.function;

public interface ModifiedFunction {
    float calculate(Function in, float d);

    default float hValue(float x) {
        return (float) Math.max(Math.abs(x / 1000.0), 0.0001);
    }
}
