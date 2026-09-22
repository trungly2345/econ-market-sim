package com.example.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class MarketAPI {

  public static void main(String args[]) {

    String apiKey = System.getenv("EIA_API_KEY");

    String uri = "https://api.eia.gov/v2/seriesid/PET.EMM_EPM0_PTE_NUS_DPG.W?api_key=??";

    try {
      fetchData(uri);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

  }

  public static HttpResponse<String> fetchData(String uri) throws IOException, InterruptedException {

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().header("Accept", "application/json").uri(URI.create(uri)).GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    System.out.println("Status Code " + response.statusCode());
    System.out.println(response.body());
    System.out.println(response.headers());
    return response;

  }
}
