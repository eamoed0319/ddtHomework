package com.worldline.interview.engine.implement;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.fuel.FuelType;
import com.worldline.interview.fuel.implement.Diesel;
import com.worldline.interview.fuel.implement.Petrol;

public class InternalCombustionEngine extends Engine {

    private static final int BATCH_SIZE = 8;

    public InternalCombustionEngine(FuelType requiredFuelType) {
        super(requiredFuelType);
    }

    @Override
    public void checkFuelType(FuelType fuelType) {
        if (!(fuelType instanceof Petrol) && !(fuelType instanceof Diesel)) {
            throw new IllegalStateException("Wrong fuel type.");
        }
    }

    @Override
    public Integer getBatchSize() {
        return BATCH_SIZE;
    }

}
