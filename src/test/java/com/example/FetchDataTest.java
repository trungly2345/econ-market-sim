//package com.example;
//

/***
 * @TODO: WILL USE LATER, DON'T NEED FOR NOW
 *  MAKING A REPO FOR MARKET PRICE
 */
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.io.IOException;
//import java.net.http.HttpClient;
//import java.util.List;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import com.example.client.EiaClient;
//import com.example.domain.MarketPriceObservation;
//import com.example.domain.MarketQuantityObservation;
//import com.example.service.MarketDataService;
//import com.example.repository.MarketPriceRepository;
//
//class FetchDataTest {
//    @Test
//    @Disabled("Temporarily disabled during PostgreSQL integration")
//    void testFetch() throws IOException, InterruptedException {
//
//        String apiKey = System.getenv("EIA_API_KEY");
//
//
//
//        System.out.println("API key length: " + apiKey.length());
//
//        EiaClient client = new EiaClient(HttpClient.newHttpClient(), "https://api.eia.gov/v2", apiKey);
//        MarketPriceRepository priceRepository;
//        MarketDataService marketService = new MarketDataService(client,priceRepository );
//        List<MarketPriceObservation> data = marketService.getNaturalGasPrices();
//
//        System.out.println("===========Market Price=============");
//        for (MarketPriceObservation observation : data) {
//            System.out.println(observation.getPeriod() + " " + observation.getObservedPrice());
//            System.out.println(observation.toString());
//        }
//
//
//        System.out.println("===========Market Quantity=============");
//        List<MarketQuantityObservation> quantityData = marketService.getNaturalGasConsumption();
//
//        for (MarketQuantityObservation observation : quantityData) {
//            System.out.println(observation.getPeriod() + " " + observation.getObservedQuantity());
//            System.out.println(observation.toString());
//        }
//
//        assertNotNull(data);
//        assertFalse(data.isEmpty());
//        assertNotNull(quantityData);
//        assertFalse(quantityData.isEmpty());
//    }
//}