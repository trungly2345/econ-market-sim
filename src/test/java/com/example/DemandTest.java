package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.domain.ExponentialDemand;
import com.example.domain.LinearDemand;
import com.example.domain.QuadraticDemand;

class DemandTest {

    @Test
    void testQuantityDemandedLinear() {
        System.out.println("Calculate Quantity Demanded Test using Linear Demand");
        LinearDemand demand = new LinearDemand(1000, 10);

        double expected = 900.0;
        double actual = demand.calculateQuantityDemanded(10);

        System.out.println("Quantity Demanded using Linear Demand: " + actual + " Expected: " + expected + "\n");
        assertEquals(expected, actual, .1);

    }

    @Test
    void testQuantityDemandedQuadratic() {
        System.out.println("Calculate Quantity Demanded Test using Quadratic Demand");
        QuadraticDemand demand2 = new QuadraticDemand(1200, 800, 60);

        double expected2 = 785;
        double actual2 = demand2.calculateQuantityDemanded(.5);

        System.out.println("Quantity Demanded using Quadratic Demand " + actual2 + " Expected: " + expected2 + "\n");
        assertEquals(expected2, actual2, .1);

    }

    @Test
    void testQuantityDemandedExponential() {
        System.out.println("Calculate Quantity Demanded Test using Exponential Demand");
        ExponentialDemand demand3 = new ExponentialDemand(1200, 0.04);

        double expected3 = 804.4;
        double actual3 = demand3.calculateQuantityDemanded(10);

        System.out.println("Quantity Demanded using Exponential Demand " + actual3 + " Expected: " + expected3 + "\n");
        assertEquals(expected3, actual3, .1);

    }

    @Test
    void testQuantityDemandedDecreaseWhenPriceIncrease() {
        System.out.println("Law of Demand Test 1 using Linear Demand");

        LinearDemand demand = new LinearDemand(1000, 10);

        double before_price = 1.35;
        double after_price = 3.20;

        double before = demand.calculateQuantityDemanded(before_price);

        System.out.println("Qty Demand at price using Linear Demand: " + before_price + " is: " + before);

        double after = demand.calculateQuantityDemanded(after_price);

        System.out.println("Qty Demand at price using Linear Demand: " + after_price + " is: " + after + "\n");

        System.out.println("Law of Demand Test 1 using Exponential Demand");

        ExponentialDemand demand2 = new ExponentialDemand(1200, 0.04);

        double before2 = demand2.calculateQuantityDemanded(before_price);

        System.out.println("Qty Demand at price using Exponential Demand: " + before_price + " is: " + before2);

        double after2 = demand2.calculateQuantityDemanded(after_price);

        System.out.println("Qty Demand at price using Exponential Demand: " + after_price + " is: " + after2 + "\n");

        System.out.println("Law of Demand Test 1 using Quadratic Demand");
        QuadraticDemand demand3 = new QuadraticDemand(1200, 800, 60);

        double before3 = demand3.calculateQuantityDemanded(before_price);

        System.out.println("Qty Demand at price using Quadratic Demand: " + before_price + " is: " + before3);

        double after3 = demand3.calculateQuantityDemanded(after_price);

        System.out.println("Qty Demand at price using Quadratic Demand: " + after_price + " is: " + after3 + "\n");

        assertTrue(before > after);
        assertTrue(before2 > after2);
        assertTrue(before3 > after3);
    }

    @Test
    void testQuantityDemandedIncreaseWhenPriceDecrease() {
        System.out.println("Law of Demand Test 2");
        LinearDemand demand = new LinearDemand(1000, 10);

        double before_price = 1;
        double after_price = .5;
        double before = demand.calculateQuantityDemanded(before_price);

        System.out.println("Qty Demand at price: " + before_price + " is: " + before);

        double after = demand.calculateQuantityDemanded(after_price);

        System.out.println("Qty Demand at price: " + after_price + " is: " + after + "\n");

        System.out.println("Law of Demand Test 2 using Exponential Demand");

        ExponentialDemand demand2 = new ExponentialDemand(1200, 0.04);

        double before2 = demand2.calculateQuantityDemanded(before_price);

        System.out.println("Qty Demand at price using Exponential Demand: " + before_price + " is: " + before2);

        double after2 = demand2.calculateQuantityDemanded(after_price);

        System.out.println("Qty Demand at price using Exponential Demand: " + after_price + " is: " + after2 + "\n");

        System.out.println("Law of Demand Test 2 using Quadratic Demand");
        QuadraticDemand demand3 = new QuadraticDemand(1200, 800, 60);

        double before3 = demand3.calculateQuantityDemanded(before_price);

        System.out.println("Qty Demand at price using Quadratic Demand: " + before_price + " is: " + before3);

        double after3 = demand3.calculateQuantityDemanded(after_price);

        System.out.println("Qty Demand at price using Quadratic Demand: " + after_price + " is: " + after3 + "\n");

        assertTrue(before < after);
        assertTrue(before2 < after2);
        assertTrue(before3 < after3);
    }

    @Test
    void testQuantityDemandedAtChokePrice() {
        System.out.println("Test Quantity Demanded At Choke Price");

        LinearDemand d = new LinearDemand(1000, 10);

        double expected = 0.00;

        double actual = d.calculateQuantityDemanded(100);

        assertEquals(expected, actual, 0.001);

        System.out.println("Quantity Demanded at choke price: " + actual + " Expected: " + expected + "\n");

    }

    @Test
    void exponentialDemandShouldApproachZeroAtHighPrice() {
        System.out.println("Test Quantity Demanded At Choke Price Exponential");

        ExponentialDemand d = new ExponentialDemand(1200, 0.04);

        double expected = 21.98;

        double actual = d.calculateQuantityDemanded(100);
        System.out.println("Quantity Demanded at choke price: " + actual + " Expected: " + expected + "\n");


        assertEquals(expected, actual, .01);

       
    }

    @Test
    void testQuantityDemandedAtChokePriceQuadratic() {
        System.out.println("Test Quantity Demanded At Choke Price Quadratic");

        QuadraticDemand d = new QuadraticDemand(1200, 800, 60);

        double expected = 0.00;

        double actual = d.calculateQuantityDemanded(100);

        assertEquals(expected, actual, 0.01);

        System.out.println("Quantity Demanded at choke price: " + actual + " Expected: " + expected + "\n");

    }

    @Test
    void testQuantityLinearDemandedAboveChokePrice() {
        System.out.println("Test Quantity Demanded Above Choke Price");

        LinearDemand d = new LinearDemand(1000, 10);

        double expected = 0.00;

        // market.setPrice(150);
        double price = 150;

        double actual = d.calculateQuantityDemanded(price);

        assertEquals(expected, actual, 0.01);

        System.out.println("Quantity Demand At Price: " + price + " is: " + actual + " Expected: " + expected + "\n");

    }

    @Test
    void testQuantityQuadraticDemandedAboveChokePrice() {
        System.out.println("Test Quantity Demanded Above Choke Price");

        QuadraticDemand d = new QuadraticDemand(1200, 800, 60);

        double expected = 0.00;

        double actual = d.calculateQuantityDemanded(150);

          System.out.println("Quantity Demanded at choke price: " + actual + " Expected: " + expected + "\n");

        assertEquals(expected, actual, 0.01);

      

}
}