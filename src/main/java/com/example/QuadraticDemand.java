package com.example;

public class QuadraticDemand implements DemandModel{

    // Q_d = aP^2 - bP - c

    private double curvatureA;
    private double curvatureB;
    private double maxQuantityDemanded;


    public QuadraticDemand(double maxQuantityDemanded, double curvatureA, double curvatureB){
        this.maxQuantityDemanded = maxQuantityDemanded;
        this.curvatureA = curvatureA;
        this.curvatureB = curvatureB;
    }

    public double getCurvatureA() {
        return curvatureA;
    }

    public void setCurvatureA(double curvatureA) {
        this.curvatureA = curvatureA;
    }

    public double getCurvutureB() {
        return curvatureB;
    }


    public void setCurvutureB(double curvutureB) {
        this.curvatureB = curvutureB;
    }

    public double getMaxQuantityDemand() {
        return maxQuantityDemanded;
    }



    public void setMaxQuantityDemand(double maxQuantityDemanded) {
        this.maxQuantityDemanded = maxQuantityDemanded;
    }


    @Override
    public double calculateQuantityDemanded(double price){
      double result = maxQuantityDemanded - (curvatureA * price) - (curvatureB * Math.pow(price,2)) ;
      return Math.max(0,result);
    }
}
