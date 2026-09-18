package com.example.domain;


/**
 * Public interface for the Supply Model 
 * 
 * the suppley model should calculate the quantity supplied in either form of equation 
 * The model respresents the supply curve in supply and demand model 
 * 
 * @param price
 * @return quantity supplied in any form of equation
 */
public interface SupplyModel {
    double calculateQuantitySupplied(double price);
}