package com.example.solver;

import java.util.Optional;

import com.example.domain.EquilibriumResult;
import com.example.domain.Market;

public class BisectionSolver implements EquilibirumSolver {



    @Override
    public Optional<EquilibriumResult> findEquilibrium(Market market, double highPrice) {
       
        double low = 0;
        int iterations = 0; 
        int max_iterations = 100;

        while(iterations < max_iterations){
            double mid = (low + highPrice) / 2;

            
            double qd = market.getQuantityDemandedAt(mid);
            double qs = market.getQuantitySuppliedAt(mid);
            double difference = Math.abs(qd - qs);

            if(difference < .1){
                return Optional.of(new EquilibriumResult(mid, qd, qs));
            }

            if(qd > qs){
                low = mid;
            } else {
                highPrice = mid;
            }
             iterations++;
        }
       return Optional.empty();

    }


        
        
    }


    
