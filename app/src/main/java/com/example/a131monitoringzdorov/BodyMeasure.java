package com.example.a131monitoringzdorov;

public class BodyMeasure {
    private float weight;
    private int steps;

    public BodyMeasure(float weight, int steps) {
        this.weight = weight;
        this.steps = steps;
    }

    public float getWeight() {
        return weight;
    }

    public int getSteps() {
        return steps;
    }
}
