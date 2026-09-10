package com.example;

public class Supply {
   private double baseIntercept; 
   private double slope; 
   private double price; 

    public double getBaseIntercept() {
    return baseIntercept;
}

   public void setBaseIntercept(double baseIntercept) {
    this.baseIntercept = baseIntercept;
   }

   public double getSlope() {
    return slope;
   }

   public void setSlope(double slope) {
    this.slope = slope;
   }

   public double getPrice() {
    return price;
   }

   public void setPrice(double price) {
    this.price = price;
   }

    public Supply(double baseIntercept, double slope){
        this.baseIntercept = baseIntercept;
        this.slope = slope; 

    }

    public double calculatedQuantitySupplied(double price){
        double result = baseIntercept  + (slope*price);

        return Math.max(0, result);
    }

    
    

    
}
