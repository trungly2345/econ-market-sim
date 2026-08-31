package com.example;

public class Market{

    private String good; 
    private int quantityDemanded;
    private int quantitySupplied; 
    private double price; 


    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public int getQuantitydemanded() {
        return quantityDemanded;
    }

    public void setQuantitydemanded(int quantityDemanded) {
        this.quantityDemanded = quantityDemanded;
    }

    public int getQuantitysupplied() {
        return quantitySupplied;
    }

    public void setQuantity_supplied(int quantitySupplied) {
        this.quantitySupplied = quantitySupplied;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private int getMarketImbalance(){
        return quantityDemanded - quantitySupplied;
    }

    public Market(String good, int quantityDemanded, int quantitySupplied, double price) {
        this.good = good; 
        this.quantityDemanded = quantityDemanded;
        this.quantitySupplied = quantitySupplied;
        this.price = price;
    }

    public String getStatus(){
        if (getMarketImbalance() > 0){
            return "Shortage";
        }else if (getMarketImbalance() < 0){
            return "Surplus";
        }else {
            return "Equilibrium";
        }
        
        }



 }