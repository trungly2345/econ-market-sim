package com.example.service;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import com.example.persistence.MarketObservationEntity;
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

import javax.swing.text.html.Option;

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

  @Autowired
  private MarketQuantityRepository quantityRepository;

  private MarketQuantityObservationEntity marketQuantity;
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
  public List<MarketPriceObservationEntity> savePriceObservations(YearMonth period) throws IOException, InterruptedException {
    var observations = getNaturalGasPrices();



    for(var observation: observations) {
      var existing = priceRepository.findByPeriod(period);
      if (existing.isPresent()) {
        var entity = existing.get();
        entity.setObservedPrice(observation.getObservedPrice());
        priceRepository.save(observation);
      } else {
        priceRepository.saveAll(observations);
      }
    }

    return observations;

  }

  @Transactional
  public List<MarketQuantityObservationEntity> saveQuantityObservations() throws IOException, InterruptedException {
    var observations = getNaturalGasConsumption();

    // if the record is a duplicate, delete them

    for (var observation : observations) {
      var existing = quantityRepository.findByPeriod(observation.getPeriod());
      if (existing.isPresent()) {
       var entity = existing.get();
       entity.setObservedQuantity(observation.getObservedQuantity());
       quantityRepository.save(entity);
      } else {
        quantityRepository.save(observation);
      }
    }

    return observations;
  }

}
