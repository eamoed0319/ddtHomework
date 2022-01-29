package com.worldline.interview.engine.implement;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.FuelType;

public class InternalCombustionEngine extends Engine {

    private static final int BATCH_SIZE = 8;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
    }

    @Override
    public void checkFuelType(FuelType fuelType) {
        if (!FuelType.PETROL.equals(fuelType) && !FuelType.DIESEL.equals(fuelType)) {
            throw new IllegalStateException("Wrong fuel type.");
        }
    }

    @Override
    public int getBatchSize() {
        return BATCH_SIZE;
    }

}
