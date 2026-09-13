package com.example;

import java.util.Optional;

public class BruteForceSolver implements EquilibirumSolver {


    @Override
    public Optional<EquilibriumResult> findEquilibrium(Market market, double maxPrice) {
        double price = 0;
        

        while (price < maxPrice){

        double qd = market.getQuantityDemandedAt(price);
        double qs = market.getQuantitySuppliedAt(price);
        double difference = Math.abs(qd - qs);

         if (difference < .1){
           return Optional.of(new EquilibriumResult(price, qd, qs));
         }

         price += 0.01;

    }
        // NOTE: Change later to Optional<EquilibriumResult> 
        return Optional.empty();

    }
}

