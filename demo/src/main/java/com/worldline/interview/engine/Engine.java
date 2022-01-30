package com.worldline.interview.engine;

import com.worldline.interview.fuel.FuelType;

public abstract class Engine {

    private boolean running;
    private int fuelLevel;
    private final FuelType requiredFuelType;
    private FuelType fuelType;

    public Engine(FuelType requiredFuelType) {
        checkFuelType(requiredFuelType);
        this.requiredFuelType = requiredFuelType;
        running = false;
        fuelLevel = 0;
    }

    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
        checkFuelType(fuelType);
        int fuelMaxLevel = fuelType.getFuelMaxLevel();
        if (fuelLevel >= 0 && fuelLevel <= fuelMaxLevel) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > fuelMaxLevel) {
            this.fuelLevel = fuelMaxLevel;
        }
        else {
            this.fuelLevel = 0;
        }

        this.fuelType = fuelType;
    }

    public abstract void checkFuelType(FuelType fuelType);

    public Double getCostPerBatch() {
        return this.requiredFuelType.getCostPerBatch();
    }

    public abstract Integer getBatchSize();

}
