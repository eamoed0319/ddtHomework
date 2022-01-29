package com.worldline.interview;

public enum FuelType {
    PETROL(9, 100),
    DIESEL(12, 100),
    WOOD(4.35, 10),
    COAL(5.65, 20);

    private final double costPerBatch;

    private final int fuelMaxLevel;

    FuelType(double costPerBatch, int fuelMaxLevel) {
        this.costPerBatch = costPerBatch;
        this.fuelMaxLevel = fuelMaxLevel;
    }

    public double getCostPerBatch() {
        return costPerBatch;
    }

    public int getFuelMaxLevel() {
        return fuelMaxLevel;
    }
}
