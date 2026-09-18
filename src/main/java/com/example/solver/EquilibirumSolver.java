package com.example.solver;

import java.util.Optional;

import com.example.domain.EquilibriumResult;
import com.example.domain.Market;

public interface EquilibirumSolver {

    Optional<EquilibriumResult> findEquilibrium(Market market, double price);

}