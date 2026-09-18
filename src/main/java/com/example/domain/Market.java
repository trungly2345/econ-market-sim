package com.example.domain;

public class Market{

    private String good; 
    private double price; 
    private DemandModel demandModel;
    private SupplyModel supplyModel; 
        
    public Market(String good, double price, DemandModel demandModel, SupplyModel supplyModel) {
        this.good = good; 
        this.demandModel = demandModel;
        this.supplyModel = supplyModel;
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

    public double getQuantityDemandedAt(double price){
        return demandModel.calculateQuantityDemanded(price);
    }

    public double getQuantitySuppliedAt(double price){
        return supplyModel.calculateQuantitySupplied(price);
    }

    public double getMarketImbalanceAt(double price){
        return getQuantityDemandedAt(price) - getQuantitySuppliedAt(price);
    }

    
    public String getStatus(){
        double tolerance = 0.1;
        if (getMarketImbalanceAt(price) > tolerance){
            return "Shortage";
        }else if (getMarketImbalanceAt(price) < -tolerance){
            return "Surplus";
        }else {
            return "Equilibrium";
        }
        
        }

 }