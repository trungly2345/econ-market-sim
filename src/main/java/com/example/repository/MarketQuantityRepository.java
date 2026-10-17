package com.example.repository;

import com.example.persistence.MarketPriceObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketQuantityRepository extends JpaRepository<MarketPriceObservationEntity, Long> {
}
