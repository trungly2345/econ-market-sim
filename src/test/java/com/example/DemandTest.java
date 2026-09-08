package com.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemandTest {

    @Test
    void testQuantityDemanded() {
        System.out.println("Calculate Quantity Demanded Test");
        Demand demand = new Demand(1000, 10);

        double expected = 900.0;
        double actual = demand.calculateQuantityDemanded(10);

        assertEquals(expected, actual);
        System.out.println("Quantity Demanded " + actual + " Expected: " + expected +"\n");
    }


    @Test 
    void testQuantityDemandedDecreaseWhenPriceIncrease()  {
        System.out.println("Law of Demand Test 1");
         Demand demand = new Demand(1000, 10);

         demand.setPrice(0);

         double before = demand.calculateQuantityDemanded(demand.getPrice());
         
         System.out.println("Qty Demand at price: " + demand.getPrice() + " is: " + before);

        demand.setPrice(4);

         double after = demand.calculateQuantityDemanded(demand.getPrice());

         System.out.println("Qty Demand at price: " + demand.getPrice() + " is: " + after +"\n" );

         assertTrue(before > after);
    }


    @Test 
    void testQuantityDemandedIncreaseWhenPriceDecrease()  {
        System.out.println("Law of Demand Test 2");
         Demand demand = new Demand(1000, 10);
         
         demand.setPrice(10);

         double before = demand.calculateQuantityDemanded(demand.getPrice());
         
         System.out.println("Qty Demanded at price: " + demand.getPrice() + " is: " + before);

         demand.setPrice(5);

         double after = demand.calculateQuantityDemanded(demand.getPrice());

         System.out.println("Qty Demanded at price: " + demand.getPrice() + " is: " + after +"\n");

         assertTrue(before < after);
    }

    @Test 
    void testQuantityDemandedAtChokePrice(){
        System.out.println("Test Quantity Demanded At Choke Price");

        Demand d = new Demand(1000,10);


        double expected = 0.00;

        double actual = d.calculateQuantityDemanded(100);

        assertEquals(expected, actual, 0.001);

        System.out.println("Quantity Demanded at choke price: " + actual + " Expected: " + expected + "\n");

    }

    @Test 
    void testQuantityDemandedAboveChokePrice(){
        System.out.println("Test Quantity Demanded Above Choke Price");

        Demand d = new Demand(1000,10);


        double expected = 0.00;

        d.setPrice(150);
        
        double actual = d.calculateQuantityDemanded(d.getPrice());

        assertEquals(expected, actual, 0.001);

        System.out.println("Quantity Demand At Price: " +d.getPrice() +" is: " + actual + " Expected: " + expected + "\n" );

    }
}