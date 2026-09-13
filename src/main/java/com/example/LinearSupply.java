package com.example;

public class LinearSupply implements SupplyModel {
   private double baseSupply; 
   private double slope; 
   
    public double getBaseSupply() {
    return baseSupply;
}

   public void setBaseSupply(double baseSupply) {
    this.baseSupply = baseSupply;
   }

   public double getSlope() {
    return slope;
   }

   public void setSlope(double slope) {
    this.slope = slope;
   }


    public LinearSupply(double baseSupply, double slope){
        this.baseSupply = baseSupply;
        this.slope = slope; 

    }


    @Override 
    public double calculateQuantitySupplied(double price){
        double result = baseSupply  + (slope*price);

        return Math.max(0, result);
    }

    
    

    
}
