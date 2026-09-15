package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class SupplyTest {

    @Test
    void testQuantitySupply() {
        System.out.println("Calculate Quantity Supplied Test");
    

        
        SupplyModel supplyModel = new LinearSupply(1000, 10);

        double expected = 1100;
        double actual = supplyModel.calculateQuantitySupplied(10);


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
    void testQuantitySupplyBelowChokePrice() {
        System.out.println("Test Quantity Supplied Below Choke Price");

        
        LinearSupply supply = new LinearSupply(-200, 200);
        double price = 0.5;

        double expected = 0.00;
        

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

}
