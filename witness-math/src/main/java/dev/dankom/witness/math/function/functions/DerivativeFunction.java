package dev.dankom.witness.math.function.functions;

import dev.dankom.witness.math.function.Function;
import dev.dankom.witness.math.function.ModifiedFunction;

public class DerivativeFunction implements ModifiedFunction {
    @Override
    public float calculate(Function f, float x) {
        float h = hValue(x);
        float xph = f.calculate(x + h);
        float xmh = f.calculate(x - h);
        return 1.0f / (2.0f * h) * (xph - xmh) -
                1.0f / (12.0f * h) * (f.calculate(x + 2.0f * h) - 2.0f * xph + 2.0f * xmh - f.calculate(x - 2.0f * h));
    }
}
