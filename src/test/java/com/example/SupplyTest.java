package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SupplyTest {
    @Test
    void testQuantitySupply() {
        System.out.println("Calculate Quantity Supplied Test");
        Supply supply = new Supply(1000, 10);

        double expected = 1100;
        double actual = supply.calculatedQuantitySupplied(10);

        assertEquals(expected, actual);
        System.out.println("Quantity Supplied " + actual + " Expected: " + expected + "\n");
    }

    @Test
    void testQuantitySuppliedIncreaseWhenPriceIncrease() {
        System.out.println("Law of Supply Test 1");
        Supply supply = new Supply(1000, 10);

        supply.setPrice(0);

        double before = supply.calculatedQuantitySupplied(supply.getPrice());

        System.out.println("Qty Supplied at price: " + supply.getPrice() + " is: " + before);

        supply.setPrice(4);

        double after = supply.calculatedQuantitySupplied(supply.getPrice());

        System.out.println("QtySupplied at price: " + supply.getPrice() + " is: " + after + "\n");

        assertTrue(before < after);
    }

    @Test
    void testQuantitySuppliedDecreaseWhenPriceDecrease() {
        System.out.println("Law of Supply Test 2");
        Supply supply = new Supply(1000, 10);

        supply.setPrice(10);

        double before = supply.calculatedQuantitySupplied(supply.getPrice());

        System.out.println("QtySupplied at price: " + supply.getPrice() + " is: " + before);

        supply.setPrice(5);

        double after = supply.calculatedQuantitySupplied(supply.getPrice());

        System.out.println("QtySupplied at price: " + supply.getPrice() + " is: " + after + "\n");

        assertTrue(before > after);
    }

    @Test
    void testQuantityDemandedAtChokePrice() {
        System.out.println("Test Quantity Demanded At Choke Price");

        Demand d = new Demand(1000, 10);

        double expected = 0.00;

        double actual = d.calculateQuantityDemanded(100);

        assertEquals(expected, actual, 0.001);

        System.out.println("Quantity Demanded at choke price: " + actual + " Expected: " + expected + "\n");

    }

    @Test
    void testQuantityDemandedAboveChokePrice() {
        System.out.println("Test Quantity Demanded Above Choke Price");

        Demand d = new Demand(1000, 10);

        double expected = 0.00;

        d.setPrice(150);

        double actual = d.calculateQuantityDemanded(d.getPrice());

        assertEquals(expected, actual, 0.001);

        System.out.println(
                "Quantity Demand At Price: " + d.getPrice() + " is: " + actual + " Expected: " + expected + "\n");

    }

}
