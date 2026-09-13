package com.example;

import java.util.Optional;

public interface EquilibirumSolver {

    Optional<EquilibriumResult> findEquilibrium(Market market, double price);

}