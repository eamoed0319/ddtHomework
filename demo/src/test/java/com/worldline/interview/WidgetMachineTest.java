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
    void givenSteamEngine_whenInitSteamEngineWithPetrol_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Petrol())
        , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenSteamEngine_whenInitSteamEngineWithDiesel_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Diesel())
        , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenSteamEngineInitWithCoal_whenFillPetrol_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Coal()).fill(new Petrol(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenSteamEngineInitWithCoal_whenFillDiesel_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Coal()).fill(new Diesel(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenSteamEngineInitWithWood_whenFillPetrol_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Wood()).fill(new Petrol(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenSteamEngineInitWithWood_whenFillDiesel_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Wood()).fill(new Diesel(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenInternalCombustionEngineInitWithPetrolAndFill10FuelLevelPetrol_when20Quantity_thenThat27IsReturned() {
        FuelType petrol = new Petrol();
        Engine steamEngine = new InternalCombustionEngine(petrol);
        steamEngine.fill(petrol, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        Assertions.assertEquals(27, widgetMachine.produceWidgets(20));
    }

    @Test
    void givenInternalCombustionEngineInitWithDieselAndFill10FuelLevelDiesel_when20Quantity_thenThat43Point5IsReturned() {
        FuelType diesel = new Diesel();
        Engine steamEngine = new InternalCombustionEngine(diesel);
        steamEngine.fill(diesel, 10);
        WidgetMachine widgetMachine = new WidgetMachine(steamEngine);
        Assertions.assertEquals(36, widgetMachine.produceWidgets(20));
    }

    @Test
    void givenInternalCombustionEngine_whenInitInternalCombustionEngineWithWood_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Wood())
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenInternalCombustionEngine_whenInitInternalCombustionEngineWithCoal_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Coal())
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenInternalCombustionEngineInitWithPetrol_whenFillWood_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Petrol()).fill(new Wood(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenInternalCombustionEngineInitWithPetrol_whenFillCoal_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Petrol()).fill(new Coal(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenInternalCombustionEngineInitWithDiesel_whenFillWood_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Diesel()).fill(new Wood(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }

    @Test
    void givenInternalCombustionEngineInitWithDiesel_whenFillCoal_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Diesel()).fill(new Coal(), 10)
                , "IllegalStateException was expected");
        Assertions.assertEquals("Wrong fuel type.", thrown.getMessage());
    }
}