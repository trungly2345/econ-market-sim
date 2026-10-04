package com.example.springconfig;

import java.net.http.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.client.EiaClient;

@Configuration
public class EiaConfig {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.newHttpClient();
    }   


    @Value("${eia.base-url}")
    private String baseUrl;

    @Value("${eia.api-key}")
    private String apiKey;
  

    @Bean
    public EiaClient eiaClient(HttpClient httpClient) {
        return new EiaClient(httpClient, baseUrl, apiKey);
    }   


}
