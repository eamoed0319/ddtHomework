package com.worldline.interview;

import com.worldline.interview.engine.Engine;

public class WidgetMachine {

    private final Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity, engine);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity, Engine engine) {
        int batch = 0;
        int batchCount = 0;

        while (batch < quantity) {
            batch = batch + engine.getBatchSize();
            batchCount++;
        }

        return batchCount * engine.getCostPerBatch();
    }


}
