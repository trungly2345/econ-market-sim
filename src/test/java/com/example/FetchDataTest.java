package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.client.EiaClient;
import com.example.domain.MarketPriceObservation;
import com.example.domain.MarketQuantityObservation;
import com.example.service.MarketDataService;

class FetchDataTest {
    @Test
    void testFetch() throws IOException, InterruptedException {

        String apiKey = System.getenv("EIA_API_KEY");


        System.out.println("API key length: " + apiKey.length());

        EiaClient client = new EiaClient(HttpClient.newHttpClient(), "https://api.eia.gov/v2", apiKey);
        MarketDataService marketService = new MarketDataService(client);
        List<MarketPriceObservation> data = marketService.getNaturalGasPrices();

        System.out.println("===========Market Price=============");
        for (MarketPriceObservation observation : data) {
            System.out.println(observation.getPeriod() + " " + observation.getObservedPrice());
            System.out.println(observation.toString());
        }


        System.out.println("===========Market Quantity=============");
        List<MarketQuantityObservation> quantityData = marketService.getNaturalGasConsumption();

        for (MarketQuantityObservation observation : quantityData) {
            System.out.println(observation.getPeriod() + " " + observation.getObservedQuantity());
            System.out.println(observation.toString());
        }
            
        assertNotNull(data);
        assertFalse(data.isEmpty());
        assertNotNull(quantityData);
        assertFalse(quantityData.isEmpty());
    }
}