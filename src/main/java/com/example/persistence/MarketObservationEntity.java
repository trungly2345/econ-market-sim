package com.example.persistence;

import java.math.BigDecimal;
import java.time.YearMonth;

import com.example.Enums.DataSource;
import com.example.Enums.MarketSeries;
import com.example.Enums.PriceUnit;
import com.example.Enums.QuantityUnit;

import jakarta.persistence.*;


@Entity
@Table(name ="market_observations", 
    uniqueConstraints = {@UniqueConstraint(name = "unique_market_obs", columnNames = {"series", "period", "source"})}
)
public class MarketObservationEntity {
    protected MarketObservationEntity(){
    }

    public MarketObservationEntity(MarketSeries series, YearMonth period, DataSource source, BigDecimal observedPrice,BigDecimal observedQuantity, PriceUnit priceUnit, QuantityUnit quantityUnit) {
        this.series = series;
        this.period = period;
        this.source = source;
        this.observedPrice = observedPrice;
        this.observedQuantity = observedQuantity;
        this.priceUnit = priceUnit;
        this.quantityUnit = quantityUnit;
    }


    public Long getId() {
        return id;
    }

    public MarketSeries getSeries() {
        return series;
    }

    public YearMonth getPeriod() {
        return period;
    }

    public DataSource getSource() {
        return source;
    }

    public BigDecimal getObservedPrice() {
        return observedPrice;
    }

    public BigDecimal getObservedQuantity() {
        return observedQuantity;
    }

    public PriceUnit getPriceUnit() {
        return priceUnit;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MarketSeries series;

    @Column(nullable = false)
    private YearMonth period;
 
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DataSource source;
    
    @Column(name = "price_observed")
    private BigDecimal observedPrice;
    
    @Column(name = "quantity_observed")
    private BigDecimal observedQuantity;
    
    @Column(name = "price_unit")
    @Enumerated(EnumType.STRING)
    private PriceUnit priceUnit;
    
    @Column(name = "quantity_unit")
    @Enumerated(EnumType.STRING)
    private QuantityUnit quantityUnit;
    
   
}
