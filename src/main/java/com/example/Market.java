package com.example;

public class Market{

    private String good; 
    private double price; 
    private Demand demand;
    private Supply supply; 
    private EquilibriumResult equilibriumResult;
        
    public Market(String good, double price, Demand demand, Supply supply) {
        this.good = good; 
        this.demand = demand;
        this.supply = supply;
        this.price = price;
    }
    
    
    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantityDemanded(){
        return demand.calculateQuantityDemanded(price);
    }

    public double getQuantitySupplied(){
        return supply.calculatedQuantitySupplied(price);
    }

    public double getMarketImbalance(){
        return getQuantityDemanded() - getQuantitySupplied();
    }

    
    public String getStatus(){
        double tolerance = 0.1;
        if (getMarketImbalance() > tolerance){
            return "Shortage";
        }else if (getMarketImbalance() < -tolerance){
            return "Surplus";
        }else {
            return "Equilibrium";
        }
        
        }


    public EquilibriumResult findEquilibrium(){
       
        double low = 0;
        int iterations = 0;
        int max_iterations = 100;

        double high = demand.getDemandIntercept()/demand.getSlope();
        

        while (iterations < max_iterations){
        
        double mid = (low + high) / 2;

        setPrice(mid);

        double qd = getQuantityDemanded();
        double qs = getQuantitySupplied();
        double difference = Math.abs(qd - qs);

         if (difference < .1){
           return new EquilibriumResult(mid, qd, qs);
         }

        if (qd > qs){
          low = mid;
        } else {
            high = mid;
        }
        iterations++;
    }
        // NOTE: Change later to Optional<EquilibriumResult> 
        return null;

    }

     public EquilibriumResult findEquilibriumBruteForce(){
      
        double startPrice = 0;
        double maxPrice = demand.getDemandIntercept()/demand.getSlope();
        

        while (startPrice < maxPrice){

        setPrice(startPrice);
        double qd = getQuantityDemanded();
        double qs = getQuantitySupplied();
        double difference = Math.abs(qd - qs);

         if (difference < .1){
           return new EquilibriumResult(startPrice, qd, qs);
         }

         startPrice += 0.01;

    }
        // NOTE: Change later to Optional<EquilibriumResult> 
        return null;

    }



 }