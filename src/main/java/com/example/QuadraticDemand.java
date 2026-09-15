package com.example;

public class QuadraticDemand implements DemandModel{

    // Q_d = aP^2 - bP - c

    private double curvatureA;
    private double curvatureB;
    private double maxQuantityDemanded;

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
      double result = (curvatureA * Math.pow(price,2)) - (curvatureB * price) - maxQuantityDemanded;
      return Math.max(0,result);
    }
}
