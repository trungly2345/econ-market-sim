package com.example;

public class Main {
   public static void main(String[] args) {

      Demand employerDemand = new Demand(108.4, 0.4);
      Supply candidateSupply = new Supply(83, 0.2);

      Market juniorSweMarket = new Market("US Entry-Level Software Developers",85, employerDemand,candidateSupply);

      System.out.println(juniorSweMarket.getStatus());
      // System.out.println(juniorSweMarket.findEquilibrium());

      EquilibriumResult result = juniorSweMarket.findEquilibrium();

      if (result != null) {
         System.out.printf("Equilibrium Price: %.2f%n", result.getEquilibriumPrice());
         System.out.printf("Quantity Demanded: %.2f%n",result.getEquilibriumQD());
         System.out.printf("Quantity Supplied: %.2f%n",result.getEquilibriumQS());
      }

   }

}
