package com.example.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EiaClient {

  private final HttpClient client;
  private final String baseUrl;
  private final String apiKey;

  public EiaClient(HttpClient client, String baseUrl, String apiKey) {
    this.client = client;
    this.baseUrl = baseUrl;
    this.apiKey = apiKey;

  }



  public HttpResponse<String> fetchData(String route) throws IOException, InterruptedException {

    String uri = baseUrl + "/" + route + "&api_key=" + apiKey;
    ObjectMapper mapper = new ObjectMapper();

    HttpRequest request = HttpRequest.newBuilder().header("Accept", "application/json").uri(URI.create(uri)).GET()

        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    JsonNode node = mapper.readTree(response.body());

    JsonNode data = node.get("response")

        .get("data");

   


    System.out.println("Status Code " + response.statusCode());

    System.out.println(response.body());

   

    return response;
  }

}