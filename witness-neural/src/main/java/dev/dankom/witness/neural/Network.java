package dev.dankom.witness.neural;

import dev.dankom.witness.neural.builder.NetworkBuilder;
import dev.dankom.witness.neural.layer.Layer;

import java.util.ArrayList;
import java.util.List;

public abstract class Network {
    private final NetworkBuilder builder;
    private final List<Layer> layers;

    public Network(NetworkBuilder builder) {
        this.builder = builder;
        this.layers = new ArrayList<>();
    }

    public int getLayerIndex(Layer layer) {
        for (int i = 0; i < layers.size(); i++) {
            Layer l = layers.get(i);
            if (l == layer) {
                return i;
            }
        }
        return -1;
    }

    public NetworkBuilder getBuilder() {
        return builder;
    }

    public List<Layer> getLayers() {
        return layers;
    }
}
