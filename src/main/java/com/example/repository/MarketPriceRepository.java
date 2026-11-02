package com.example.repository;

import com.example.persistence.MarketPriceObservationEntity;
import com.example.persistence.MarketQuantityObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.YearMonth;
import java.util.Optional;

public interface MarketPriceRepository extends JpaRepository<MarketPriceObservationEntity, Long> {
    Optional<MarketPriceObservationEntity> findByPeriod(YearMonth period);

}
