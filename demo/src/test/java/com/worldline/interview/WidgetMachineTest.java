package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.engine.implement.InternalCombustionEngine;
import com.worldline.interview.engine.implement.SteamEngine;
import org.junit.jupiter.api.Test;

class WidgetMachineTest {

    @Test
    void produceWidgetsBySteamEngineAndCoalTest() {
        Engine steamEngine = new SteamEngine(FuelType.COAL);
        steamEngine.fill(FuelType.COAL, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsBySteamEngineAndWoodTest() {
        Engine steamEngine = new SteamEngine(FuelType.WOOD);
        steamEngine.fill(FuelType.WOOD, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsByInternalCombustionEngineAndPetrolTest() {
        Engine internalCombustionEngine = new InternalCombustionEngine(FuelType.PETROL);
        internalCombustionEngine.fill(FuelType.PETROL, 10);
        WidgetMachine widgetMachine = new WidgetMachine(internalCombustionEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsByInternalCombustionEngineAndDieselTest() {
        Engine internalCombustionEngine = new InternalCombustionEngine(FuelType.DIESEL);
        internalCombustionEngine.fill(FuelType.DIESEL, 10);
        WidgetMachine widgetMachine = new WidgetMachine(internalCombustionEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }
}