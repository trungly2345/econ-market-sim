package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class SupplyTest {

    @Test
    void testQuantityLinearSupply() {
        System.out.println("Calculate Quantity Supplied Test");
    

        
        LinearSupply supply = new LinearSupply(1000, 10);

        double expected = 1100;
        double actual = supply.calculateQuantitySupplied(10);


        assertEquals(expected, actual);
        System.out.println("Quantity Supplied " + actual + " Expected: " + expected + "\n");
    }

    @Test
    void testQuantityQuadraticSupply() {
        System.out.println("Calculate Quantity Supplied Test");
    

        
        QuadraticSupply supply = new QuadraticSupply(5.5, 0.6, 0.1);

        double expected = 7.625;
        double actual = supply.calculateQuantitySupplied(2.5);


        assertEquals(expected, actual);
        System.out.println("Quantity Supplied " + actual + " Expected: " + expected + "\n");
    }

    @Test
    void testQuantitySuppliedIncreaseWhenPriceIncrease() {
        System.out.println("Law of Supply Test 1");
        LinearSupply linearSupply = new LinearSupply(1000, 10);
        // Market market = new Market("Test good", 5, null, linearSupply);

        double beforePrice = 5;
        double afterPrice = 10;
        
        double before = linearSupply.calculateQuantitySupplied(beforePrice);
        
        System.out.println("QtySupplied at price: " +  beforePrice + " is: " + before);

        

        double after = linearSupply.calculateQuantitySupplied(afterPrice);

        System.out.println("QtySupplied at price: " +  afterPrice + " is: " + after + "\n");

        assertTrue(before < after);
    }

    @Test
    void testQuantitySuppliedIncreaseWhenPriceIncreaseQuadratic(){
        System.out.println("Law of Supply Test 1 (Quadratic)");
        QuadraticSupply quadraticSupply = new QuadraticSupply(10, 10, 1000);

        double beforePrice = 5;
        double afterPrice = 10;
        
        double before = quadraticSupply.calculateQuantitySupplied(beforePrice);
        
        System.out.println("QtySupplied at price: " +  beforePrice + " is: " + before);

        

        double after = quadraticSupply.calculateQuantitySupplied(afterPrice);

        System.out.println("QtySupplied at price: " +  afterPrice + " is: " + after + "\n");

        assertTrue(before < after);
    }

    @Test
    void testQuantitySuppliedDecreaseWhenPriceDecrease() {
        System.out.println("Law of Supply Test 2");
        LinearSupply linearSupply = new LinearSupply(1000, 10);

        double beforePrice = 25;
        double afterPrice = 10;

       

        double before = linearSupply.calculateQuantitySupplied(beforePrice);

        System.out.println("QtySupplied at price: " + beforePrice + " is: " + before);

        

        double after = linearSupply.calculateQuantitySupplied(afterPrice);

        System.out.println("QtySupplied at price: " + afterPrice + " is: " + after + "\n");

        assertTrue(before > after);
    }

    @Test 
    void testQuantitySuppliedDecreaseWhenPriceDecreaseQuadratic(){
        System.out.println("Law of Supply Test 2 (Quadratic)");
        QuadraticSupply quadraticSupply = new QuadraticSupply(10, 10, 1000);

        double beforePrice = 25;
        double afterPrice = 10;

       

        double before = quadraticSupply.calculateQuantitySupplied(beforePrice);

        System.out.println("QtySupplied at price: " + beforePrice + " is: " + before);

        

        double after = quadraticSupply.calculateQuantitySupplied(afterPrice);

        System.out.println("QtySupplied at price: " + afterPrice + " is: " + after + "\n");

        assertTrue(before > after);
    }

    @Test
    void testQuantitySupplyAtChokePrice() {
        System.out.println("Test Quantity Supplied At Choke Price");

        LinearSupply linearSupply = new LinearSupply(-200, 200);
        double chokePrice = 1;


        double expected = 0.00;

        double actual = linearSupply.calculateQuantitySupplied(chokePrice);
        
        System.out.println("Quantity supplied at price: " + chokePrice + " is: " + "Qs=" + actual + " Expected: " + expected + "\n");

        assertEquals(expected, actual, 0.001);


    }

    @Test 
    void testQuantitySupplyAtChokePriceQuadratic(){
        System.out.println("Test Quantity Supplied At Choke Price (Quadratic)");

        QuadraticSupply quadraticSupply = new QuadraticSupply(-200, 200, 1000);
        double chokePrice = 0.358;


        double expected = 0.00;

        double actual = quadraticSupply.calculateQuantitySupplied(chokePrice);
        
        System.out.println("Quantity supplied at price: " + chokePrice + " is: " + "Qs=" + actual + " Expected: " + expected + "\n");

        assertEquals(expected, actual, 0.001);


    }

    @Test
    void testQuantitySupplyBelowChokePrice() {
        System.out.println("Test Quantity Supplied Below Choke Price");

        
        LinearSupply supply = new LinearSupply(-200, 200);
        double price = 0.2;

        double expected = 0.00;
        

        double actual = supply.calculateQuantitySupplied(price);

        System.out.println(
                "Quantity supplied at price: " + price + " is: " + "Qs=" + actual + " Expected: " + expected + "\n");
        
        assertEquals(expected, actual, 0.001);
     
    }

    @Test 
    void testQuantitySupplyBelowChokePriceQuadratic(){
        System.out.println("Test Quantity Supplied Below Choke Price (Quadratic)");

        
        QuadraticSupply supply = new QuadraticSupply(-200, 200, 1000);
        double price = 0.2;

        double expected = 0.00;
        

        double actual = supply.calculateQuantitySupplied(price);

        System.out.println(
                "Quantity supplied at price: " + price + " is: " + "Qs=" + actual + " Expected: " + expected + "\n");
        
        assertEquals(expected, actual, 0.001);
     
    }

    @Test 
    void testQuantitySupplyAboveChokePriceQuadratic(){
        System.out.println("Test Quantity Supplied Above Choke Price (Quadratic)");

        
        QuadraticSupply supply = new QuadraticSupply(-200, 200, 1000);
        double price = 0.5;

        double expected = 150;
        

        double actual = supply.calculateQuantitySupplied(price);

        System.out.println(
                "Quantity supplied at price: " + price + " is: " + "Qs=" + actual + " Expected: " + expected + "\n");
        
        assertEquals(expected, actual, 0.001);
     
    }

    @Test 
    void testQuantitySuppliedNonNegative(){
        System.out.println("Test Quantity Supplied Should Be Non-Negative");

        LinearSupply supply = new LinearSupply(-200, 200);


        double actual = supply.calculateQuantitySupplied(0.5);

        assertEquals(0, actual, 0.001);

        System.out.println("Quantity supplied at price: " + 0.5 + " is: " + actual + " Expected: " + 0 + "\n");
        
    }

    @Test 
    void testQuantitySuppliedNonNegativeQuadratic(){
        System.out.println("Test Quantity Supplied Should Be Non-Negative (Quadratic)");

        QuadraticSupply supply = new QuadraticSupply(-200, 200, -1000);

        double actual = supply.calculateQuantitySupplied(0.5);
        System.out.println("Quantity supplied at price: " + 0.5 + " is: " + actual + " Expected: " + 0 + "\n");

        assertEquals(0, actual, 0.001);
       
        
    }

}
