package com.worldline.interview.engine.implement;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.fuel.FuelType;
import com.worldline.interview.fuel.implement.Coal;
import com.worldline.interview.fuel.implement.Wood;

public class SteamEngine extends Engine {

    private static final int BATCH_SIZE = 2;

    public SteamEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
    }

    @Override
    public void checkFuelType(FuelType fuelType) {
        if (!(fuelType instanceof Wood) && !(fuelType instanceof Coal)) {
            throw new IllegalStateException("Wrong fuel type.");
        }
    }

    @Override
    public Integer getBatchSize() {
        return BATCH_SIZE;
    }

}
