package com.worldline.interview.engine.implement;

import com.worldline.interview.FuelType;
import com.worldline.interview.engine.Engine;

public class SteamEngine extends Engine {

    private static final int BATCH_SIZE = 2;

    public SteamEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
    }

    @Override
    public void checkFuelType(FuelType fuelType) {
        if (!FuelType.WOOD.equals(fuelType) && !FuelType.COAL.equals(fuelType)) {
            throw new IllegalStateException("Wrong fuel type.");
        }
    }

    @Override
    public int getBatchSize() {
        return BATCH_SIZE;
    }

}
