package dev.dankom.witness.math.function.functions;

import dev.dankom.witness.math.function.Function;

public class SinFunction implements Function {
    @Override
    public float calculate(float in) {
        return (float) Math.sin(in);
    }
}
