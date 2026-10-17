package com.example.service;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;

import com.example.repository.MarketQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Enums.DataSource;
import com.example.Enums.PriceUnit;
import com.example.client.EiaClient;
import com.example.persistence.MarketPriceObservationEntity;
import com.example.persistence.MarketQuantityObservationEntity;
import com.example.dto.EiaObservationDTO;
import com.example.repository.MarketPriceRepository;
import org.springframework.transaction.annotation.Transactional;

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
  @Autowired
  private MarketPriceRepository priceRepository;
  private final MarketQuantityRepository quantityRepository;
  /***
   * Constructor for MarketDataService, 
   * Takes a dependency from eiaClient using Constructor Dependency Injection
   * @param
   * 
   */
  public MarketDataService(EiaClient eiaClient, MarketPriceRepository priceRepository, MarketQuantityRepository quantityRepository) {

    this.eiaClient = eiaClient;
    this.priceRepository = priceRepository;
    this.quantityRepository = quantityRepository;
  }

  public List<MarketPriceObservationEntity> getNaturalGasPrices() throws IOException, InterruptedException {

    List<EiaObservationDTO> eiaResponse = eiaClient.fetchPriceData(
        "natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][0]=NUS&facets[process][0]=PRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=12");
    return eiaResponse.stream().map(this::toMarketPriceObservation).toList();

  }

  private MarketPriceObservationEntity toMarketPriceObservation(EiaObservationDTO dto) {
    return new MarketPriceObservationEntity(YearMonth.parse(dto.getPeriod()), dto.getValue(), PriceUnit.USD_PER_MCF,
        DataSource.EIA);
  }

  public List<MarketQuantityObservationEntity> getNaturalGasConsumption() throws IOException, InterruptedException {

    List<EiaObservationDTO> eiaResponse = eiaClient.fetchQuantityData(
        "natural-gas/cons/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][0]=NUS&facets[process][0]=VRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=12");
    return eiaResponse.stream().map(this::toMarketQuantityObservation).toList();

  }

  private MarketQuantityObservationEntity toMarketQuantityObservation(EiaObservationDTO dto) {
    return new MarketQuantityObservationEntity(YearMonth.parse(dto.getPeriod()), dto.getValue(), DataSource.EIA);
  }



  @Transactional
  public List<MarketPriceObservationEntity> savePriceObervations() throws IOException, InterruptedException {
    var observations = getNaturalGasPrices();
      return priceRepository.saveAll(observations);

  }


}
