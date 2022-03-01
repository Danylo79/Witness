package dev.dankom.witness;

import java.util.List;

public class Neuron {
    private final Network parent;
    private final List<Neuron> in;
    private final List<Neuron> out;
    private final int weight;

    public Neuron(Network parent, List<Neuron> in, List<Neuron> out, int weight) {
        this.parent = parent;
        this.in = in;
        this.out = out;
        this.weight = weight;
    }

    public Network getParent() {
        return parent;
    }

    public List<Neuron> getIn() {
        return in;
    }

    public List<Neuron> getOut() {
        return out;
    }

    public int getWeight() {
        return weight;
    }
}
