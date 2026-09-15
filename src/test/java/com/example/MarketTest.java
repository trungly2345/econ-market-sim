package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class MarketTest {

    @Test
    void findEquilibrium() {

        LinearDemand d = new LinearDemand(1000, 10);
        LinearSupply s = new LinearSupply(200, 5);
        BruteForceSolver solver = new BruteForceSolver();

        Market m = new Market("Test Goods", 10, d, s);

        double expected = 53.33;
        Long start = System.nanoTime();

        Optional<EquilibriumResult> actualA = solver.findEquilibrium(m, 200);

        Long end = System.nanoTime();

        Long time = end - start;

        if (actualA.isPresent()) {
            assertEquals(expected, actualA.get().getEquilibriumPrice(), 0.01);
            System.out.println("Finding Market Equilibirum by Brute Force Test");
            System.out.println("Equilibrium Price: " + actualA.get().getEquilibriumPrice());
            System.out.println("Equilibrium Quantity: " + actualA.get().getEquilibriumQD());
            System.out.println("Equilibrium Quantity: " + actualA.get().getEquilibriumQS());
            System.out.println("Time elapsed: " + time + " ns");
        }

    }

    @Test
    void findEquilibriumBisectionTest() {

        System.out.println("\nFinding Market Equilibirum Bisection Test");
        LinearDemand d = new LinearDemand(20000, 3000);
        LinearSupply s = new LinearSupply(0, 2000);
        BisectionSolver solver = new BisectionSolver();

        Market m = new Market("Test Goods", 10, d, s);

        double expected = 4;
        Long start = System.nanoTime();
        Optional<EquilibriumResult> actual = solver.findEquilibrium(m, 200);
        Long end = System.nanoTime();

        Long time = end - start;

        assertNotNull(actual);
        assertEquals(expected, actual.get().getEquilibriumPrice(), 0.01);
        System.out.println("Equilibrium Price: " + actual.get().getEquilibriumPrice());
        System.out.println("Equilibrium Quantity: " + actual.get().getEquilibriumQD());
        System.out.println("Equilibrium Quantity: " + actual.get().getEquilibriumQS());
        System.out.println("Time elapsed: " + time + " ns");

    }

    @Test
    void testWtihinTolerelance() {
        System.out.println("\nTest Quanitites within Tolerance ");
        LinearDemand d = new LinearDemand(1000, 10);
        LinearSupply s = new LinearSupply(200, 5);
        EquilibirumSolver solver = new BisectionSolver();

        Market m = new Market("Test Goods", 10, d, s);

        Optional<EquilibriumResult> actual = solver.findEquilibrium(m, 200);

        assertNotNull(actual);
        double tolerance = 0.1;

        double difference = Math.abs(actual.get().getEquilibriumQD() - actual.get().getEquilibriumQS());

        System.out.println("Equilibrium Quantity Demanded: " + actual.get().getEquilibriumQD());
        System.out.println("Equilibrium Quantity Supplied: " + actual.get().getEquilibriumQS());
        System.out.println("Difference: " + difference + " within tolerance 0.1\n");
        assertTrue(difference < tolerance);

    }

    @Test
    void TestMarketStatus() {

        System.out.println("Test Market Status ");
        LinearDemand d = new LinearDemand(1000, 10);
        LinearSupply s = new LinearSupply(200, 5);

        Market m = new Market("Test Good", 10, d, s);

        String actual = m.getStatus();
        String expected = "Shortage";

        System.out.println("Quantity Demanded " + m.getQuantityDemandedAt(m.getPrice()));
        System.out.println("Quantity Supplied " + m.getQuantitySuppliedAt(m.getPrice()));

        System.out.println("Market Status should be in " + expected + " and the actual status is " + actual + "\n");

        d.setBaseDemand(200);
        s.setBaseSupply(1000);

        String actual1 = m.getStatus();
        String expected1 = "Surplus";

        System.out.println("Quantity Demanded " + m.getQuantityDemandedAt(m.getPrice()));
        System.out.println("Quantity Supplied " + m.getQuantitySuppliedAt(m.getPrice()));
        System.out.println("Market Status should be in " + expected1 + " and the actual status is " + actual1 + "\n");

        d.setBaseDemand(1000);
        s.setBaseSupply(200);

        m.setPrice(53.33);

        String actual2 = m.getStatus();
        String expected2 = "Equilibrium";

        System.out.println("Quantity Demanded " + m.getQuantityDemandedAt(m.getPrice()));
        System.out.println("Quantity Supplied " + m.getQuantitySuppliedAt(m.getPrice()));
        System.out.println("Market Status should be in " + expected2 + " and the actual status is " + actual2 + "\n");

        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);

    }

    @Test
    void testNoEquilibrium() {

        System.out.println("No equilibrium found test\n");

        LinearDemand d = new LinearDemand(100, 10);
        LinearSupply s = new LinearSupply(500, 5);

        Market m = new Market("Test Goods", 10, d, s);
        EquilibirumSolver solver = new BruteForceSolver();

        Optional<EquilibriumResult> actual = solver.findEquilibrium(m, 200);

        assertTrue(actual.isEmpty());

        System.out.println("Equilibrium not found at price " + m.getPrice() + "\n");

    }

    @Test
    void solverShouldNotMutateMarketPrice() {

        DemandModel d = new LinearDemand(100, 10);
        LinearSupply s = new LinearSupply(200, 5);
        double initial_market_price = 10.5;
        Market m = new Market("Test Goods", initial_market_price, d, s);

        BisectionSolver solver = new BisectionSolver();

        Optional<EquilibriumResult> actual = solver.findEquilibrium(m, 10);

        double expected_market_price = initial_market_price;
        assertNotNull(actual);
        assertEquals(expected_market_price, m.getPrice());
        System.out.println("Testing Market Price Immutaiblity Expected Market Price: " + expected_market_price + "\n");
        System.out.println(
                "Testing Market Price Immutaiblity Actual Market Price: " + m.getPrice() + "\n");

    }
}
