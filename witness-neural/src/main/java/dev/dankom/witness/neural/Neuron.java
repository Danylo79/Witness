package dev.dankom.witness.neural;

import dev.dankom.witness.neural.layer.Layer;

public class Neuron {
    private final Layer parent;
    private final float weight;

    public Neuron(Layer parent, float weight) {
        this.parent = parent;
        this.weight = weight;
    }

    public float calculateOutput(float summativeIn) {
        return getParent().getParent().getBuilder().getActivationFunction().calculate(summativeIn);
    }

    public Layer getParent() {
        return parent;
    }

    public float getWeight() {
        return weight;
    }
}
