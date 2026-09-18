package com.example;

public class QuadraticDemand implements DemandModel{

    // Q_d = aP^2 - bP - c

    private double curvatureA;
    private double curvatureB;
    private double baseDemand;


    public QuadraticDemand(double baseDemand, double curvatureA, double curvatureB){
        this.baseDemand = baseDemand;
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

    public double getBaseDemand() {
        return baseDemand;
    }



    public void setBaseDemand(double baseDemand) {
        this.baseDemand = baseDemand;
    }


    @Override
    public double calculateQuantityDemanded(double price){
      double result = baseDemand - (curvatureA * price) - (curvatureB * Math.pow(price,2)) ;
      return Math.max(0,result);
    }
}
