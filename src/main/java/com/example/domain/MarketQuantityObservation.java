package com.example.domain;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Objects;

import com.example.Enums.DataSource;

/**
 * MarketQuantityObservation
 */
public class MarketQuantityObservation {

    private final YearMonth period;
    private final BigDecimal observedQuantity;
    private final DataSource source;

    public MarketQuantityObservation(YearMonth period, BigDecimal observedQuantity, DataSource source) {
        this.period = Objects.requireNonNull(period, "period is required");
        this.observedQuantity = Objects.requireNonNull(observedQuantity, "observedQuantity is required");
        this.source = Objects.requireNonNull(source, "source is required");
    }

    public YearMonth getPeriod() {
        return period;
    }

    public BigDecimal getObservedQuantity() {
        return observedQuantity;
    }

    public DataSource getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "MarketQuantityObservation [period=" + period + ", observedQuantity=" + observedQuantity + ", source="
                + source + "]";
    }

    

}
