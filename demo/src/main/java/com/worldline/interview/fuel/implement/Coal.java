package com.worldline.interview.fuel.implement;

import com.worldline.interview.fuel.FuelType;

public class Coal implements FuelType {

    private static final double COST_PER_BATCH = 5.65;

    private static final int FUEL_MAX_LEVEL = 20;

    @Override
    public double getCostPerBatch() {
        return COST_PER_BATCH;
    }

    @Override
    public int getFuelMaxLevel() {
        return FUEL_MAX_LEVEL;
    }
}
