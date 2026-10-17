package com.example.persistence;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Objects;

import com.example.Enums.DataSource;
import com.example.Enums.PriceUnit;
import jakarta.persistence.*;


@Entity
@Table(name="market_price_observations")
public class MarketPriceObservationEntity {



    protected MarketPriceObservationEntity(){}

    @Column(name ="period", nullable = false, length = 7)
    private YearMonth period;

    @Column(name ="observed_price",nullable = false)
    private BigDecimal observedPrice;

    @Column(name ="price_unit", nullable = false)
    private PriceUnit priceUnit;

    @Column(name ="source", nullable = false)
    @Enumerated(EnumType.STRING)
    private DataSource source;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public MarketPriceObservationEntity(YearMonth period, BigDecimal observedPrice, PriceUnit priceUnit, DataSource source) {
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






    
