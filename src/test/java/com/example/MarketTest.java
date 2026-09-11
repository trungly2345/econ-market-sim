package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class MarketTest {

    
    
    @Test 
    void findEquilibrium(){

      
        Demand d = new Demand(1000,10);
        Supply s = new Supply(200 ,5);
        
        
        Market m = new Market("Test Goods", 10, d, s);
        
        double expected = 53.33;
        Long start = System.nanoTime();
        
        EquilibriumResult actualA = m.findEquilibriumBruteForce();

        Long end = System.nanoTime();

        Long time = end - start;

       

        if (!actualA.equals(null)){
        assertEquals(expected, actualA.getEquilibriumPrice(), 0.01);
        System.out.println("Finding Market Equilibirum by Brute Force Test");
        System.out.println("Equilibrium Price: " + actualA.getEquilibriumPrice());
        System.out.println("Equilibrium Quantity: " + actualA.getEquilibriumQD());
        System.out.println("Equilibrium Quantity: " + actualA.getEquilibriumQS());
        System.out.println("Time elapsed: " + time + " ns");
        }
        

    }

    @Test 
    void findEquilibriumBisectionTest(){

        System.out.println("\nFinding Market Equilibirum Bisection Test");
        Demand d = new Demand(1000,10);
        Supply s = new Supply(200,5);

        Market m = new Market("Test Goods", 10, d, s);

        double expected = 53.33;
        Long start = System.nanoTime();
        Optional<EquilibriumResult> actual = m.findEquilibrium();
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
    void testWtihinTolerelance(){
        System.out.println("\nTest Quanitites within Tolerance ");
        Demand d = new Demand(1000,10);
        Supply s = new Supply(200,5);

        Market m = new Market("Test Goods", 10, d, s);

        Optional<EquilibriumResult> actual = m.findEquilibrium();

        assertNotNull(actual);
        double tolerance = 0.1;

        double difference = Math.abs(actual.get().getEquilibriumQD() - actual.get().getEquilibriumQS());

        System.out.println("Equilibrium Quantity Demanded: " + actual.get().getEquilibriumQD());
        System.out.println("Equilibrium Quantity Supplied: " + actual.get().getEquilibriumQS());
        System.out.println("Difference: " + difference + " within tolerance 0.01\n");
        assertTrue(difference < tolerance);


    }


    @Test 
    void TestMarketStatus(){

         System.out.println("Test Market Status ");
          Demand d = new Demand(1000,10);
          Supply s = new Supply(200,5);

          Market m = new Market("Test Good", 10,d,s);


          String actual = m.getStatus();
          String expected = "Shortage";

          System.out.println("Quantity Demanded " + m.getQuantityDemanded());
          System.out.println("Quantity Supplied " + m.getQuantitySupplied());

          System.out.println("Market Status should be in " + expected + " and the actual status is " + actual + "\n" );
          
          
          d.setDemandIntercept(200);
          s.setBaseIntercept(1000);



          String actual1 = m.getStatus();
          String expected1 = "Surplus";

          System.out.println("Quantity Demanded " + m.getQuantityDemanded());
          System.out.println("Quantity Supplied " + m.getQuantitySupplied());
          System.out.println("Market Status should be in " + expected1 + " and the actual status is " + actual1 + "\n" );
        

          d.setDemandIntercept(1000);
          s.setBaseIntercept(200);

          m.setPrice(53.33);



          String actual2 = m.getStatus();
          String expected2 = "Equilibrium";

          System.out.println("Quantity Demanded " + m.getQuantityDemanded());
          System.out.println("Quantity Supplied " + m.getQuantitySupplied());
          System.out.println("Market Status should be in " + expected2 + " and the actual status is " + actual2 + "\n" );
        



          
          assertEquals(expected, actual);
          assertEquals(expected1, actual1);
          assertEquals(expected2, actual2);

    }



    @Test 

    void testNoEquilibrium(){

        System.out.println("No equilibrium found test\n");

        Demand d = new Demand(100,10);
        Supply s = new Supply(500 ,5);
        
        
        Market m = new Market("Test Goods", 10, d, s);
        

       Optional<EquilibriumResult> actual = m.findEquilibrium();

       assertTrue(actual.isEmpty());

       System.out.println("Equilibrium not found at price " + m.getPrice() + "\n");

    }


    
        
        
    
}
