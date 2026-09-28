package com.example.service;

import java.net.http.HttpClient;

import com.example.client.EiaClient;

public class MarketDataService {


    public static void main(String args[])throws Exception {


    EiaClient eiaClient = new EiaClient(HttpClient.newHttpClient(), "https://api.eia.gov/v2", System.getenv("EIA_API_KEY"));


    try {
        eiaClient.fetchData("natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][]=NUS&&facets[process][0]=PRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=10");
    } catch (Exception e) {
        e.printStackTrace();
    }


    }

    
}
