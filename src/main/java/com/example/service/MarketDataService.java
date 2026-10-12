package com.example.service;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Enums.DataSource;
import com.example.Enums.PriceUnit;
import com.example.client.EiaClient;
import com.example.domain.MarketPriceObservation;
import com.example.domain.MarketQuantityObservation;
import com.example.dto.EiaObservationDTO;
import com.example.repository.MarketPriceRepository;


/**
 * <p> 
 * Performs data fetching from an client response 
 * using EIA API
 * </p> 
 * 
 */
@Service
public class MarketDataService {

  private final EiaClient eiaClient;
  private final MarketPriceRepository priceRepository;
  /***
   * Constructor for MarketDataService, 
   * Takes a dependency from eiaClient using Constructor Dependency Injection
   * @param
   * 
   */
  public MarketDataService(EiaClient eiaClient, MarketPriceRepository priceRepository) {

    this.eiaClient = eiaClient;
    this.priceRepository = priceRepository;
  }

  public List<MarketPriceObservation> getNaturalGasPrices() throws IOException, InterruptedException {

    List<EiaObservationDTO> eiaResponse = eiaClient.fetchPriceData(
        "natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][0]=NUS&facets[process][0]=PRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=12");
    return eiaResponse.stream().map(this::toMarketPriceObservation).toList();

  }

  private MarketPriceObservation toMarketPriceObservation(EiaObservationDTO dto) {
    return new MarketPriceObservation(YearMonth.parse(dto.getPeriod()), dto.getValue(), PriceUnit.USD_PER_MCF,
        DataSource.EIA);
  }

  public List<MarketQuantityObservation> getNaturalGasConsumption() throws IOException, InterruptedException {

    List<EiaObservationDTO> eiaResponse = eiaClient.fetchQuantityData(
        "natural-gas/cons/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][0]=NUS&facets[process][0]=VRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=12");
    return eiaResponse.stream().map(this::toMarketQuantityObservation).toList();

  }

  private MarketQuantityObservation toMarketQuantityObservation(EiaObservationDTO dto) {
    return new MarketQuantityObservation(YearMonth.parse(dto.getPeriod()), dto.getValue(), DataSource.EIA);
  }

}
