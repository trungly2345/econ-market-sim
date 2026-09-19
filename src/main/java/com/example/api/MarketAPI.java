package com.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;


public class MarketAPI {

HttpClient client;
HttpRequest request;


public static void main(String args[]){
   MarketAPI marketAPI = new MarketAPI();
   marketAPI.client =  HttpClient.newHttpClient();
   marketAPI.request = HttpRequest.newBuilder().header("Accept","application/json").uri(URI.create("https://api.eia.gov/v2/seriesid/PET.EMM_EPM0_PTE_NUS_DPG.W?api_key=???")).GET().build();

 fetchData(marketAPI.client, marketAPI.request);


}


public static HttpResponse<String> fetchData(HttpClient client, HttpRequest request){
 try {

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
   
   if (response.statusCode() >= 200 && response.statusCode() < 300){
      System.out.println("Status Code " + response.statusCode());
    //    System.out.println(response.body());
    // System.out.println(response.headers());

        return response;
       
   } else {
    System.out.println(request);
    System.out.println("Status Code " + response.statusCode());
    System.out.println("Error " + response.body());
   }

 } catch (IOException | InterruptedException e ){
    e.printStackTrace();
    
        }
        return null;
    }
    
    
}
