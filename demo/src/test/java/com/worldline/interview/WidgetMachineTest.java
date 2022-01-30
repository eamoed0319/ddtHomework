package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.engine.implement.InternalCombustionEngine;
import com.worldline.interview.engine.implement.SteamEngine;
import com.worldline.interview.fuel.FuelType;
import com.worldline.interview.fuel.implement.Coal;
import com.worldline.interview.fuel.implement.Diesel;
import com.worldline.interview.fuel.implement.Petrol;
import com.worldline.interview.fuel.implement.Wood;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WidgetMachineTest {

    @Test
    void givenSteamEngineInitWithCoalAndFill10FuelLevelCoal_when20Quantity_thenThat56Point5IsReturned() {
        FuelType coal = new Coal();
        Engine steamEngine = new SteamEngine(coal);
        steamEngine.fill(coal, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        Assertions.assertEquals(56.5, widgetMachine.produceWidgets(20));
    }

    @Test
    void givenSteamEngineInitWithWoodAndFill10FuelLevelWood_when20Quantity_thenThat43Point5IsReturned() {
        FuelType wood = new Wood();
        Engine steamEngine = new SteamEngine(wood);
        steamEngine.fill(wood, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        Assertions.assertEquals(43.5, widgetMachine.produceWidgets(20));
    }

    @Test
    void givenInternalCombustionEngineInitWithPetrolAndFill10FuelLevelPetrol_when20Quantity_thenThat27IsReturned() {
        FuelType petrol = new Petrol();
        Engine internalCombustionEngine = new InternalCombustionEngine(petrol);
        internalCombustionEngine.fill(petrol, 10);
        WidgetMachine widgetMachine = new WidgetMachine(internalCombustionEngine);
        Assertions.assertEquals(27, widgetMachine.produceWidgets(20));
    }

    @Test
    void givenInternalCombustionEngineInitWithDieselAndFill10FuelLevelDiesel_when20Quantity_thenThat43Point5IsReturned() {
        FuelType diesel = new Diesel();
        Engine internalCombustionEngine = new InternalCombustionEngine(diesel);
        internalCombustionEngine.fill(diesel, 10);
        WidgetMachine widgetMachine = new WidgetMachine(internalCombustionEngine);
        Assertions.assertEquals(36, widgetMachine.produceWidgets(20));
    }
}