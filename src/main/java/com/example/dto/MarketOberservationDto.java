package com.example.dto;

import java.time.LocalDate;
import java.util.List;


public class MarketOberservationDto {

    private String product_name;
    private double price;
    private List<Unit> units;


    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public List<Unit> getUnits() {
        return units;
    }
    public void setUnits(List<Unit> units) {
        this.units = units;
    } 
    




}






    
