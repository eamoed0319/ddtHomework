package com.worldline.interview.fuel.implement;

import com.worldline.interview.fuel.FuelType;

public class Wood implements FuelType {

    private static final double COST_PER_BATCH = 4.35;

    private static final int FUEL_MAX_LEVEL = 10;

    @Override
    public double getCostPerBatch() {
        return COST_PER_BATCH;
    }

    @Override
    public int getFuelMaxLevel() {
        return FUEL_MAX_LEVEL;
    }
}
