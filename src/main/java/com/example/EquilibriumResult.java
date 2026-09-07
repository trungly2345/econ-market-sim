package com.example;


public class EquilibriumResult {
    private double equilibriumPrice;
    private double equilibriumQD; 
    private double equilibriumQS;
    
    public double getEquilibriumPrice() {
        return equilibriumPrice;
    }

    public double getEquilibriumQD() {
        return equilibriumQD;
    }

    public double getEquilibriumQS() {
        return equilibriumQS;
    }


    public EquilibriumResult(double equilibriumPrice, double equilibriumQD, double equilibriumQS){
        this.equilibriumPrice = equilibriumPrice;
        this.equilibriumQD = equilibriumQD;
        this.equilibriumQS = equilibriumQS;

    }


    
   


   

}