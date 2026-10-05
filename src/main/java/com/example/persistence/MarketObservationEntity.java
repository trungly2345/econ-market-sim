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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MarketSeries series;

    
    private YearMonth period;
 
    
    @Enumerated(EnumType.STRING)
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
