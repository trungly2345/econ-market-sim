package com.example.service;

import java.io.IOException;
import java.time.YearMonth;
import java.util.List;

import com.example.Enums.DataSource;
import com.example.Enums.PriceUnit;
import com.example.client.EiaClient;
import com.example.domain.MarketPriceObservation;
import com.example.domain.MarketQuantityObservation;
import com.example.dto.EiaObservationDTO;
import org.springframework.stereotype.Service;

@Service
public class MarketDataService {

  private final EiaClient eiaClient;

  public MarketDataService(EiaClient eiaClient) {
    this.eiaClient = eiaClient;
  }

  public List<MarketPriceObservation> getNaturalGasPrices() throws IOException, InterruptedException {

    List<EiaObservationDTO> eiaResponse = eiaClient.fetchPriceData(
        "natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][0]=NUS&facets[process][0]=PRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=12");
    return eiaResponse.stream().map(this::toMarketPriceObservation).toList();

  }

  private MarketPriceObservation toMarketPriceObservation(EiaObservationDTO dto) {
    return new MarketPriceObservation(YearMonth.parse(dto.getPeriod()), dto.getValue(), PriceUnit.MILLION_CUBIC_FEET,
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
