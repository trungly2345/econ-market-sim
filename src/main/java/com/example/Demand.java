package com.example;

public class Demand {
    private double price;
    private double demandIntercept; 
    private double slope;


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getDemandIntercept() {
        return demandIntercept;
    }

    public void setDemandIntercept(double demandIntercept) {
        this.demandIntercept = demandIntercept;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public Demand(double demandIntercept, double slope){
        this.demandIntercept = demandIntercept;
        this.slope = slope;
    }


  

    public double calculateQuantityDemanded(double price) {
        double result = demandIntercept -  (slope * price);
        if (result  < 0 ) result = 0;
        return result;
    }
    
}
