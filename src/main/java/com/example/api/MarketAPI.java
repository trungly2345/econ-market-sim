package com.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MarketAPI {

  public static void main(String args[]) {

    String apiKey = System.getenv("EIA_API_KEY");

    if(apiKey == null || apiKey.isBlank()){
       throw new IllegalStateException("EIA_API_KEY is not set");
    }

    String uri1 = "https://api.eia.gov/v2/seriesid/PET.WGFUPUS2.W?api_key=" + apiKey;
    String uri2 = "https://api.eia.gov/v2/seriesid/PET.EMM_EPM0_PTE_NUS_DPG.W?api_key=" + apiKey;

    try {
      fetchData(uri1);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    try {
      fetchData(uri2);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

  }

  public static HttpResponse<String> fetchData(String uri) throws IOException, InterruptedException {

    ObjectMapper mapper = new ObjectMapper();
    

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().header("Accept", "application/json").uri(URI.create(uri)).GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

 
    JsonNode node = mapper.readTree(response.body());
    JsonNode data = node.get("response")
                       .get("data");  

    JsonNode firstObservation = data.get(0);
    JsonNode secondObservation = data.get(1);

    
  
    
    

    System.out.println("Status Code " + response.statusCode());
    System.out.println(firstObservation);
    System.out.println(secondObservation);
    
    
   


    return response;

  }
}
