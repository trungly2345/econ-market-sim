package com.example.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

import com.example.Enums.DataSource;
import com.example.Enums.PriceUnit;
import com.example.client.EiaClient;
import com.example.domain.MarketPriceObservation;
import com.example.dto.EiaObservationDTO;
import org.springframework.stereotype.Service;

@Service
public class MarketDataService {
   

    private final EiaClient eiaClient;

    public MarketDataService(EiaClient eiaClient){
      this.eiaClient = eiaClient; 
    }
      
  public List<MarketPriceObservation> getNaturalGasPrices() throws IOException, InterruptedException{

    List<EiaObservationDTO> eiaResponse = eiaClient.fetchPriceData("natural-gas/pri/sum/data/?frequency=monthly&data[0]=value&facets[duoarea][0]=NUS&facets[process][0]=PRS&start=2026-01&sort[0][column]=period&sort[0][direction]=desc&offset=0&length=12");
    return eiaResponse.stream().map(this::toMarketPriceObservation).toList();
 
  }

  private MarketPriceObservation toMarketPriceObservation(EiaObservationDTO dto) {
  return new MarketPriceObservation( YearMonth.parse(dto.getPeriod()), dto.getValue(), PriceUnit.USD_PER_MCF, DataSource.EIA);
  }
    

}
