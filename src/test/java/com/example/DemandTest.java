package com.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemandTest {

    @Test
    void testQuantityDemanded() {
        Demand demand = new Demand(1000, 10);

        double expected = 900.0;
        double actual = demand.calculateQuantityDemanded(10);

        assertEquals(expected, actual);
    }


    @Test 
    void testDemandShiftLeft()  {
         Demand demand = new Demand(1000, 10);
         
         double expected = 1000.0; 
         
         double before = demand.calculateQuantityDemanded(0);
         
         System.out.println("Demand at price: " + demand.getPrice() + " is: " + before );

         demand.setPrice(4);

         double after = demand.calculateQuantityDemanded(4);

         System.out.println("Demand at price: " + demand.getPrice() + " is: " + after );

         assertNotEquals(expected, after);
    }
}