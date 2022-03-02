package dev.dankom.witness.neural.layer;

import dev.dankom.witness.neural.Network;
import dev.dankom.witness.neural.Neuron;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private final Network parent;
    private final LayerType type;
    private final List<Neuron> neurons;

    public Layer(Network parent, LayerType type) {
        this.parent = parent;
        this.type = type;
        this.neurons = new ArrayList<>();
    }

    public Network getParent() {
        return parent;
    }

    public LayerType getType() {
        return type;
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void addNeuron(Neuron neuron) {
        neurons.add(neuron);
    }
}
