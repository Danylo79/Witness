package dev.dankom.witness.neural.builder;

import dev.dankom.witness.math.function.Function;
import dev.dankom.witness.math.function.functions.SigmoidFunction;

public class NetworkBuilder {
    private int hiddenLayers = 1;
    private int hiddenLayerNodes = 5;
    private float learningRate = 0.1f;
    private Function activationFunction = new SigmoidFunction();

    public int getHiddenLayers() {
        return hiddenLayers;
    }

    public NetworkBuilder setHiddenLayers(int hiddenLayers) {
        this.hiddenLayers = hiddenLayers;
        return this;
    }

    public int getHiddenLayerNodes() {
        return hiddenLayerNodes;
    }

    public NetworkBuilder setHiddenLayerNodes(int hiddenLayerNodes) {
        this.hiddenLayerNodes = hiddenLayerNodes;
        return this;
    }

    public float getLearningRate() {
        return learningRate;
    }

    public NetworkBuilder setLearningRate(float learningRate) {
        this.learningRate = learningRate;
        return this;
    }

    public Function getActivationFunction() {
        return activationFunction;
    }

    public NetworkBuilder setActivationFunction(Function activationFunction) {
        this.activationFunction = activationFunction;
        return this;
    }

    public static NetworkBuilder newBuilder() {
        return new NetworkBuilder();
    }
}
