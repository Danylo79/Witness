package dev.dankom.witness.math.function.functions;

import dev.dankom.witness.math.function.Function;

public class SigmoidFunction implements Function {
    @Override
    public float calculate(float in) {
        return (float) (1 / (1 + Math.pow(Math.E, (-1 * in))));
    }
}
