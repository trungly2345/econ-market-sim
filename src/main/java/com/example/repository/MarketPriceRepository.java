package com.example.repository;

import com.example.persistence.MarketPriceObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketPriceRepository extends JpaRepository<MarketPriceObservationEntity, Long> {
}
