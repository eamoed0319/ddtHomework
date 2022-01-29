package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.engine.implement.InternalCombustionEngine;
import com.worldline.interview.engine.implement.SteamEngine;
import com.worldline.interview.fuel.FuelType;
import com.worldline.interview.fuel.implement.Coal;
import com.worldline.interview.fuel.implement.Diesel;
import com.worldline.interview.fuel.implement.Petrol;
import com.worldline.interview.fuel.implement.Wood;
import org.junit.jupiter.api.Test;

class WidgetMachineTest {

    @Test
    void produceWidgetsBySteamEngineAndCoalTest() {
        FuelType coal = new Coal();
        Engine steamEngine = new SteamEngine(coal);
        steamEngine.fill(coal, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsBySteamEngineAndWoodTest() {
        FuelType wood = new Wood();
        Engine steamEngine = new SteamEngine(wood);
        steamEngine.fill(wood, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsBySteamEngineAndPetrolTest() {
        FuelType petrol = new Petrol();
        Engine steamEngine = new SteamEngine(petrol);
        steamEngine.fill(petrol, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsBySteamEngineAndDieselTest() {
        FuelType diesel = new Diesel();
        Engine steamEngine = new SteamEngine(diesel);
        steamEngine.fill(diesel, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsByInternalCombustionEngineAndPetrolTest() {
        FuelType petrol = new Petrol();
        Engine internalCombustionEngine = new InternalCombustionEngine(petrol);
        internalCombustionEngine.fill(petrol, 10);
        WidgetMachine widgetMachine = new WidgetMachine(internalCombustionEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }

    @Test
    void produceWidgetsByInternalCombustionEngineAndDieselTest() {
        FuelType diesel = new Diesel();
        Engine internalCombustionEngine = new InternalCombustionEngine(diesel);
        internalCombustionEngine.fill(diesel, 10);
        WidgetMachine widgetMachine = new WidgetMachine(internalCombustionEngine);
        System.out.println(widgetMachine.produceWidgets(20));
    }
}