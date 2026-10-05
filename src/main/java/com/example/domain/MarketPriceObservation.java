package com.example.domain;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Objects;

import com.example.Enums.DataSource;
import com.example.Enums.PriceUnit;



public class MarketPriceObservation {
    private final YearMonth period;
    private final BigDecimal observedPrice;
    private final PriceUnit priceUnit;
    private final DataSource source;

    public MarketPriceObservation(YearMonth period, BigDecimal observedPrice, PriceUnit priceUnit, DataSource source) {
        this.period = Objects.requireNonNull(period, "period is required");
        this.observedPrice = Objects.requireNonNull(observedPrice, "observedPrice is required");
        this.priceUnit = Objects.requireNonNull(priceUnit, "priceUnit is required");
        this.source = Objects.requireNonNull(source, "source is required");
    }


    public YearMonth getPeriod() {
        return period;
    }


    public BigDecimal getObservedPrice() {
        return observedPrice;
    }

    public PriceUnit getPriceUnit() {
        return priceUnit;
    }


    public DataSource getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "MarketPriceObservation [period=" + period + ", observedPrice=" + observedPrice + ", priceUnit=" + priceUnit
                + ", source=" + source + "]";
    }

    

}






    
