package com.worldline.interview.engine;

import com.worldline.interview.engine.implement.InternalCombustionEngine;
import com.worldline.interview.engine.implement.SteamEngine;
import com.worldline.interview.fuel.FuelType;
import com.worldline.interview.fuel.implement.Coal;
import com.worldline.interview.fuel.implement.Diesel;
import com.worldline.interview.fuel.implement.Petrol;
import com.worldline.interview.fuel.implement.Wood;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EngineTest {

    @Test
    void givenSteamEngineInitWithCoal_whenFill10FuelLevelCoal_thenThatIsRunningIsTrueReturned() {
        FuelType coal = new Coal();
        Engine steamEngine = new SteamEngine(coal);
        steamEngine.fill(coal, 10);
        steamEngine.start();
        Assertions.assertTrue(steamEngine.isRunning());
    }

    @Test
    void givenSteamEngineInitWithWood_whenFill10FuelLevelWood_thenThatIsRunningIsTrueReturned() {
        FuelType wood = new Wood();
        Engine steamEngine = new SteamEngine(wood);
        steamEngine.fill(wood, 10);
        steamEngine.start();
        Assertions.assertTrue(steamEngine.isRunning());
    }

    @Test
    void givenSteamEngineInitWithCoal_whenNotFill_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Coal()).start()
                , "IllegalStateException was expected");
        Assertions.assertEquals("Not able to start engine.", thrown.getMessage());
    }

    @Test
    void givenSteamEngineInitWithWood_whenNotFill_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new SteamEngine(new Wood()).start()
                , "IllegalStateException was expected");
        Assertions.assertEquals("Not able to start engine.", thrown.getMessage());
    }

    @Test
    void givenSteamEngineInitWithCoalAndFill10FuelLevelCoal_whenEngineStopAfterStart_thenThatIsRunningIsFalseReturned() {
        FuelType coal = new Coal();
        Engine steamEngine = new SteamEngine(coal);
        steamEngine.fill(coal, 10);
        steamEngine.start();
        steamEngine.stop();
        Assertions.assertFalse(steamEngine.isRunning());
    }

    @Test
    void givenSteamEngineInitWithWoodAndFill10FuelLevelWood_whenEngineStopAfterStart_thenThatIsRunningIsTrueReturned() {
        FuelType wood = new Wood();
        Engine steamEngine = new SteamEngine(wood);
        steamEngine.fill(wood, 10);
        steamEngine.start();
        steamEngine.stop();
        Assertions.assertFalse(steamEngine.isRunning());
    }

    @Test
    void givenSteamEngineInitWithCoal_whenGetCostPerBatch_thenThatDoubleReturned() {
        Assertions.assertEquals(Double.class,
                new SteamEngine(new Coal()).getCostPerBatch().getClass());
    }

    @Test
    void givenSteamEngineInitWithCoal_whenGetBatchSize_thenThatIntegerReturned() {
        Assertions.assertEquals(Integer.class,
                new SteamEngine(new Coal()).getBatchSize().getClass());
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
    void givenInternalCombustionEngineInitWithPetrol_whenFill10FuelLevelPetrol_thenThatIsRunningIsTrueReturned() {
        FuelType petrol = new Petrol();
        Engine internalCombustionEngine = new InternalCombustionEngine(petrol);
        internalCombustionEngine.fill(petrol, 10);
        internalCombustionEngine.start();
        Assertions.assertTrue(internalCombustionEngine.isRunning());
    }

    @Test
    void givenInternalCombustionInitWithDiesel_whenFill10FuelLevelDiesel_thenThatIsRunningIsTrueReturned() {
        FuelType diesel = new Diesel();
        Engine internalCombustionEngine = new InternalCombustionEngine(diesel);
        internalCombustionEngine.fill(diesel, 10);
        internalCombustionEngine.start();
        Assertions.assertTrue(internalCombustionEngine.isRunning());
    }

    @Test
    void givenInternalCombustionEngineInitWithPetrol_whenNotFill_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Petrol()).start()
                , "IllegalStateException was expected");
        Assertions.assertEquals("Not able to start engine.", thrown.getMessage());
    }

    @Test
    void givenInternalCombustionEngineInitWithDiesel_whenNotFill_thenThatIllegalStateExceptionIsReturned() {
        Exception thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> new InternalCombustionEngine(new Diesel()).start()
                , "IllegalStateException was expected");
        Assertions.assertEquals("Not able to start engine.", thrown.getMessage());
    }

    @Test
    void givenSteamEngineInitWithCoalAndFill10FuelLevelPetrol_whenEngineStopAfterStart_thenThatIsRunningIsFalseReturned() {
        FuelType petrol = new Petrol();
        Engine internalCombustionEngine = new InternalCombustionEngine(petrol);
        internalCombustionEngine.fill(petrol, 10);
        internalCombustionEngine.start();
        internalCombustionEngine.stop();
        Assertions.assertFalse(internalCombustionEngine.isRunning());
    }

    @Test
    void givenInternalCombustionEngineInitWithDieselAndFill10FuelLevelWood_whenEngineStopAfterStart_thenThatIsRunningIsTrueReturned() {
        FuelType diesel = new Diesel();
        Engine internalCombustionEngine = new InternalCombustionEngine(diesel);
        internalCombustionEngine.fill(diesel, 10);
        internalCombustionEngine.start();
        internalCombustionEngine.stop();
        Assertions.assertFalse(internalCombustionEngine.isRunning());
    }

    @Test
    void givenInternalCombustionEngineInitWithPetrol_whenGetCostPerBatch_thenThatDoubleReturned() {
        Assertions.assertEquals(Double.class,
                new InternalCombustionEngine(new Petrol()).getCostPerBatch().getClass());
    }

    @Test
    void givenInternalCombustionEngineInitWithPetrol_whenGetBatchSize_thenThatIntegerReturned() {
        Assertions.assertEquals(Integer.class,
                new InternalCombustionEngine(new Petrol()).getBatchSize().getClass());
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