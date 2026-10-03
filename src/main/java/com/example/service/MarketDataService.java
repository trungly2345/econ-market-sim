package com.example.service;

import java.net.http.HttpClient;
import java.util.List;

import com.example.client.EiaClient;
import com.example.dto.EiaObservationDTO;

public class MarketDataService {

   


  public void NormalizeEiaData(){
    HttpClient httpClient = HttpClient.newHttpClient();

    EiaClient eiaClient = new EiaClient(httpClient, "https://api.eia.gov/v2/", System.getenv("EIA_API_KEY"));
    
    try{
      List<EiaObservationDTO> eiaResponse = eiaClient.fetchPriceData("natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][0]=NUS&facets[process][0]=PRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=12");
     
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
 
  }

    

}
