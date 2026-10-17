package com.example;


/***
 * @TODO: WILL USE LATER, DON'T NEED FOR NOW
 *  MAKING A REPO FOR MARKET PRICE
 */
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import com.example.persistence.MarketPriceObservationEntity;
import org.junit.jupiter.api.Test;

import com.example.client.EiaClient;
import com.example.persistence.MarketQuantityObservationEntity;
import com.example.service.MarketDataService;
import com.example.repository.MarketPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FetchDataTest {
    @Autowired
    MarketPriceRepository priceRepository;

    @Autowired
    MarketDataService service;

    @Autowired
    private EiaClient client;


   @Test
  void testFetch() throws IOException, InterruptedException, Exception {

     String apiKey = System.getenv("EIA_API_KEY");
       System.out.println("API key length: " + apiKey.length());

       var priceData = service.getNaturalGasPrices();
       System.out.println("===========Market Price=============");

       for (MarketPriceObservationEntity observation : priceData) {
           System.out.println(observation.getPeriod() + " " + observation.getObservedPrice());
           System.out.println(observation.toString());
       }

       assertFalse(priceData.isEmpty());




       var quantityData = service.getNaturalGasConsumption();
       System.out.println("===========Market Quantity=============");

        for (MarketQuantityObservationEntity observation : quantityData) {
            System.out.println(observation.getPeriod() + " " + observation.getObservedQuantity());
            System.out.println(observation.toString());
        }
        assertFalse(quantityData.isEmpty());
    }


    @Test
    void savePriceObservations() throws Exception{
       var observations = service.savePriceObervations();

       assertFalse(observations.isEmpty());

    }

}