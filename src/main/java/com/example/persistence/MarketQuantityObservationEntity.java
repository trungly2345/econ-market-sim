package com.example.persistence;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Objects;

import com.example.Enums.DataSource;
import jakarta.persistence.*;

/**
 * MarketQuantityObservation
 */

@Entity
@Table(name = "market_quantity_observations")
public class MarketQuantityObservationEntity {


    protected MarketQuantityObservationEntity(){

    }

    @Column(name = "period", nullable = false, length = 7)
    private YearMonth period;

    @Column(name = "observed_quantity", nullable = false)
    private BigDecimal observedQuantity;



    @Column(name ="source", nullable = false)
    @Enumerated(EnumType.STRING)
    private DataSource source;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public MarketQuantityObservationEntity(YearMonth period, BigDecimal observedQuantity, DataSource source) {
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
