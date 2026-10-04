package com.example.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.EiaObservationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.JsonNode;

import java.net.http.HttpRequest;


public class EiaClient {

  private final HttpClient client;
  private final String baseUrl;
  private final String apiKey;


  public EiaClient(HttpClient client, String baseUrl, String apiKey) {
    this.client = client;
    this.baseUrl = baseUrl;
    this.apiKey = apiKey;

  }

  public List<EiaObservationDTO> fetchPriceData(String route) throws IOException, InterruptedException {

    String uri = baseUrl + "/" + route + "&api_key=" + apiKey;

    HttpRequest request = HttpRequest.newBuilder().header("Accept", "application/json").uri(URI.create(uri)).GET()

        .build();

    ObjectMapper mapper = new ObjectMapper();    

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    List<EiaObservationDTO> eiaData = new ArrayList<>();

      JsonNode root = mapper.readTree(response.body());
      JsonNode dataNode = root.path("response").path("data");


      for (JsonNode observation: dataNode){
      String period = observation.path("period").asText();
      String duoarea = observation.path("duoarea").asText();
      String product_name = observation.path("product-name").asText();
      BigDecimal value = new BigDecimal(observation.path("value").asText());

      EiaObservationDTO dto = new EiaObservationDTO();
      dto.setPeriod(period);
      dto.setDuoarea(duoarea);
      dto.setProductName(product_name);
      dto.setValue(value);
      eiaData.add(dto);
      }

    
   
  
    System.out.println("Status Code " + response.statusCode());
    // System.out.println(response.body());
    

  
    return eiaData;
  
  }


  

}