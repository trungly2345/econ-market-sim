package com.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemandTest {

    @Test
    void testQuantityDemanded() {
        System.out.println("Calculate Quantity Demanded Test");
        LinearDemand demand = new LinearDemand(1000, 10);

        double expected = 900.0;
        double actual = demand.calculateQuantityDemanded(10);

        assertEquals(expected, actual);
        System.out.println("Quantity Demanded " + actual + " Expected: " + expected +"\n");
    }


    @Test 
    void testQuantityDemandedDecreaseWhenPriceIncrease()  {
        System.out.println("Law of Demand Test 1");

      
         LinearDemand demand = new LinearDemand(1000, 10);


         double before_price = 25;
         double after_price = 50;
        

         double before = demand.calculateQuantityDemanded(before_price);
         
         System.out.println("Qty Demand at price: " + before_price + " is: " + before);
          


         double after = demand.calculateQuantityDemanded(after_price);
         

         System.out.println("Qty Demand at price: " + after_price + " is: " + after +"\n" );

         assertTrue(before > after);
    }


    @Test 
    void testQuantityDemandedIncreaseWhenPriceDecrease()  {
        System.out.println("Law of Demand Test 2");
         LinearDemand demand = new LinearDemand(1000, 10);
        

         double before_price = 10;
         double after_price = 5;
         double before = demand.calculateQuantityDemanded(before_price);
         
         System.out.println("Qty Demand at price: " + before_price + " is: " + before);

        
         double after = demand.calculateQuantityDemanded(after_price);

         System.out.println("Qty Demand at price: " + after_price + " is: " + after +"\n");

         assertTrue(before < after);
    }

    @Test 
    void testQuantityDemandedAtChokePrice(){
        System.out.println("Test Quantity Demanded At Choke Price");

        LinearDemand d = new LinearDemand(1000,10);


        double expected = 0.00;

        double actual = d.calculateQuantityDemanded(100);

        assertEquals(expected, actual, 0.001);

        System.out.println("Quantity Demanded at choke price: " + actual + " Expected: " + expected + "\n");

    }

    @Test 
    void testQuantityDemandedAboveChokePrice(){
        System.out.println("Test Quantity Demanded Above Choke Price");

      
        LinearDemand d = new LinearDemand(1000,10);


        double expected = 0.00;

        // market.setPrice(150);
        double price = 150;
        
        double actual = d.calculateQuantityDemanded(price);

        assertEquals(expected, actual, 0.001);

        System.out.println("Quantity Demand At Price: " +price +" is: " + actual + " Expected: " + expected + "\n" );

    }
}