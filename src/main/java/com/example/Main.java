package com.example;

public class Main {
   public static void main(String[] args) {
        Market market1 = new Market("coffee", 120, 80, 5.00);
        System.out.println("Market: " +market1.getGood());
        System.out.println("Price: " +market1.getPrice());
        System.out.println("Quantity Supplied: " +market1.getQuantitysupplied());
        System.out.println("Quantity Demanded: " +market1.getQuantitydemanded());
        System.out.println("Status: " + market1.getStatus());

      
        
   }


   
}
