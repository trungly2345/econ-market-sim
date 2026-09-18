package com.example;
public class QuadraticSupply implements SupplyModel {

    // Q_s = aP^2 + bP + c
    private double curvatureA; 
    private double curvatureB;
    private double baseSupply;

    public QuadraticSupply(double baseSupply,double curvatureA,double curvatureB ) {
        this.curvatureA = curvatureA;
        this.curvatureB = curvatureB;
        this.baseSupply = baseSupply;
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

    public double getBaseSupply() {
        return baseSupply;
    }
    public void setBaseSupply(double baseSupply) {
        this.baseSupply = baseSupply;
    }

    @Override
    public double calculateQuantitySupplied(double price) {
        
      double result = baseSupply + (curvatureA * price) + (curvatureB * Math.pow(price,2)) ;
      return Math.max(0,result);
    }
    
}
 