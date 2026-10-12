package com.example.repository;

import com.example.domain.MarketPriceObservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketPriceRepository extends JpaRepository<MarketPriceObservation, Long> {
}
