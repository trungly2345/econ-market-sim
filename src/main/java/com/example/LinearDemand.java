package com.example;

public class LinearDemand implements DemandModel {
    private double baseDemand; 
    private double priceSlope;
    
    public LinearDemand(double baseDemand, double priceSlope){
        this.baseDemand = baseDemand;
        this.priceSlope = priceSlope;
    }

  

    public double getBaseDemand() {
        return baseDemand;
    }

    public void setBaseDemand(double baseDemand) {
        this.baseDemand = baseDemand;
    }

    public double getPriceSlope() {
        return priceSlope;
    }

    public void setPriceSlope(double priceSlope) {
        this.priceSlope = priceSlope;
    }

    @Override
    public double calculateQuantityDemanded(double price) {
        double result = baseDemand -  (priceSlope * price);
        if (result  < 0 ) result = 0;
        return result;
    }
    
}
