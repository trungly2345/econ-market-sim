package com.example.repository;

import com.example.persistence.MarketQuantityObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.YearMonth;
import java.util.Optional;

public interface MarketQuantityRepository extends JpaRepository<MarketQuantityObservationEntity, Long> {


    Optional<MarketQuantityObservationEntity> findByPeriod(YearMonth period);
}

