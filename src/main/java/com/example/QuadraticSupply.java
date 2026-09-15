package com.example;
public class QuadraticSupply implements SupplyModel {

    // Q_s = aP^2 + bP + c
    private double curvatureA; 
    private double curvatureB;
    private double maxQuantitySupplied;


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

    public double getMaxQuantitySupplied() {
        return maxQuantitySupplied;
    }

    @Override
    public double calculateQuantitySupplied(double price) {
        
      double result = (curvatureA * Math.pow(price,2)) + (curvatureB * price) + maxQuantitySupplied;
      return Math.max(0,result);
    }
    
}
 