package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.client.EiaClient;
import com.example.domain.MarketPriceObservation;
import com.example.service.MarketDataService;

class FetchDataTest {
    @Test
    void testFetch() throws IOException, InterruptedException {

        String apiKey = System.getenv("EIA_API_KEY");

        assertNotNull(apiKey, "EIA_API_KEY is not set");
        assertFalse(apiKey.isBlank(), "EIA_API_KEY is blank");

        System.out.println("API key length: " + apiKey.length());

        EiaClient client = new EiaClient(HttpClient.newHttpClient(), "https://api.eia.gov/v2", apiKey);
        MarketDataService marketService = new MarketDataService(client);
        List<MarketPriceObservation> data = marketService.getNaturalGasPrices();

        for (MarketPriceObservation observation : data) {
            System.out.println(observation.getPeriod() + " " + observation.getObservedPrice());
            System.out.println(observation);
        }
            
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }
}