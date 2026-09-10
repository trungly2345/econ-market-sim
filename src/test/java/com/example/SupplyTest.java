package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        System.out.println("Qty Supplied at price: " + supply.getPrice() + " is: " + after + "\n");

        assertTrue(before < after);
    }

    @Test
    void testQuantitySuppliedDecreaseWhenPriceDecrease() {
        System.out.println("Law of Supply Test 2");
        Supply supply = new Supply(1000, 10);

        supply.setPrice(10);

        double before = supply.calculatedQuantitySupplied(supply.getPrice());

        System.out.println("Qty Supplied at price: " + supply.getPrice() + " is: " + before);

        supply.setPrice(5);

        double after = supply.calculatedQuantitySupplied(supply.getPrice());

        System.out.println("Qty Supplied at price: " + supply.getPrice() + " is: " + after + "\n");

        assertTrue(before > after);
    }

    @Test
    void testQuantitySupplyAtChokePrice() {
        System.out.println("Test Quantity Supplied At Choke Price");

        Supply supply = new Supply(-200, 200);

        double expected = 0.00;

        double actual = supply.calculatedQuantitySupplied(1);
        
        System.out.println("Quantity supplied at price: " + supply.getPrice() + " is: " + "Qs=" + actual + " Expected: " + expected + "\n");

        assertEquals(expected, actual, 0.001);


    }

    @Test
    void testQuantitySupplyBelowChokePrice() {
        System.out.println("Test Quantity Supplied Below Choke Price");

        Supply supply = new Supply(-200, 200);

        double expected = 0.00;

        supply.setPrice(0.5);

        double actual = supply.calculatedQuantitySupplied(supply.getPrice());

        System.out.println(
                "Quantity supplied at price: " + supply.getPrice() + " is: " + "Qs=" + actual + " Expected: " + expected + "\n");
        
        assertEquals(expected, actual, 0.001);
     
    }

    @Test 
    void testNegativeSlopeAsZero(){
        System.out.println("Test Negative Slope");

        Supply supply = new Supply(-200, 200);


        double actual = supply.calculatedQuantitySupplied(0.5);

        assertEquals(0, actual, 0.001);

        System.out.println("Quantity supplied at price: " + 0.5 + " is: " + actual + " Expected: " + 0 + "\n");
        
    }

}
