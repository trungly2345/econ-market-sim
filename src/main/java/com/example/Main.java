package com.example;

import java.util.function.DoubleUnaryOperator;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== NONLINEAR MARKET TEST ===");

        /*
         * NONLINEAR DEMAND:
         *
         * Qd = 5000 - 20P - 0.5P^2
         *
         * The P^2 term makes the demand curve nonlinear.
         */
        DoubleUnaryOperator demand = price ->
                Math.max(0,
                        5000
                        - 20 * price
                        - 0.5 * price * price
                );

        /*
         * LINEAR SUPPLY:
         *
         * Qs = 1000 + 15P
         */
        DoubleUnaryOperator supply = price ->
                1000 + 15 * price;


        // Starting market price
        double currentPrice = 80;

        double currentQD = demand.applyAsDouble(currentPrice);
        double currentQS = supply.applyAsDouble(currentPrice);


        System.out.printf("Current Price: $%.2f%n", currentPrice);
        System.out.printf("Quantity Demanded: %.2f%n", currentQD);
        System.out.printf("Quantity Supplied: %.2f%n", currentQS);

        if (currentQD > currentQS) {
            System.out.println("Market Status: Shortage");
        } else if (currentQD < currentQS) {
            System.out.println("Market Status: Surplus");
        } else {
            System.out.println("Market Status: Equilibrium");
        }


        // ----------------------------------------------------
        // BISECTION
        // ----------------------------------------------------

        long bisectionStart = System.nanoTime();

        SolverResult bisectionResult =
                bisection(
                        demand,
                        supply,
                        0,
                        100,
                        0.1,
                        100
                );

        long bisectionEnd = System.nanoTime();


        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("BISECTION RESULT");
        System.out.println("--------------------------------");

        if (bisectionResult != null) {

            System.out.printf(
                    "Equilibrium Price: $%.4f%n",
                    bisectionResult.price
            );

            System.out.printf(
                    "Quantity Demanded: %.4f%n",
                    bisectionResult.qd
            );

            System.out.printf(
                    "Quantity Supplied: %.4f%n",
                    bisectionResult.qs
            );

            System.out.printf(
                    "Difference: %.6f%n",
                    Math.abs(
                            bisectionResult.qd
                            - bisectionResult.qs
                    )
            );

            System.out.println(
                    "Iterations: "
                    + bisectionResult.iterations
            );

            System.out.println(
                    "Time: "
                    + (bisectionEnd - bisectionStart)
                    + " ns"
            );
        }


        // ----------------------------------------------------
        // BRUTE FORCE
        // ----------------------------------------------------

        long bruteStart = System.nanoTime();

        SolverResult bruteResult =
                bruteForce(
                        demand,
                        supply,
                        0,
                        100,
                        0.001,
                        0.1
                );

        long bruteEnd = System.nanoTime();


        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("BRUTE FORCE RESULT");
        System.out.println("--------------------------------");

        if (bruteResult != null) {

            System.out.printf(
                    "Equilibrium Price: $%.4f%n",
                    bruteResult.price
            );

            System.out.printf(
                    "Quantity Demanded: %.4f%n",
                    bruteResult.qd
            );

            System.out.printf(
                    "Quantity Supplied: %.4f%n",
                    bruteResult.qs
            );

            System.out.printf(
                    "Difference: %.6f%n",
                    Math.abs(
                            bruteResult.qd
                            - bruteResult.qs
                    )
            );

            System.out.println(
                    "Iterations: "
                    + bruteResult.iterations
            );

            System.out.println(
                    "Time: "
                    + (bruteEnd - bruteStart)
                    + " ns"
            );
        }
    }


    // ========================================================
    // BISECTION SOLVER
    // ========================================================

    public static SolverResult bisection(
            DoubleUnaryOperator demand,
            DoubleUnaryOperator supply,
            double low,
            double high,
            double tolerance,
            int maxIterations) {

        int iterations = 0;

        while (iterations < maxIterations) {

            iterations++;

            double mid = (low + high) / 2;

            double qd = demand.applyAsDouble(mid);
            double qs = supply.applyAsDouble(mid);

            double imbalance = qd - qs;

            if (Math.abs(imbalance) < tolerance) {

                return new SolverResult(
                        mid,
                        qd,
                        qs,
                        iterations
                );
            }

            // Shortage
            // Qd > Qs
            // Raise price
            if (imbalance > 0) {

                low = mid;

            }

            // Surplus
            // Qd < Qs
            // Lower price
            else {

                high = mid;

            }
        }

        return null;
    }


    // ========================================================
    // BRUTE FORCE SOLVER
    // ========================================================

    public static SolverResult bruteForce(
            DoubleUnaryOperator demand,
            DoubleUnaryOperator supply,
            double low,
            double high,
            double step,
            double tolerance) {

        int iterations = 0;

        double price = low;

        while (price <= high) {

            iterations++;

            double qd =
                    demand.applyAsDouble(price);

            double qs =
                    supply.applyAsDouble(price);

            double difference =
                    Math.abs(qd - qs);

            if (difference < tolerance) {

                return new SolverResult(
                        price,
                        qd,
                        qs,
                        iterations
                );
            }

            price += step;
        }

        return null;
    }


    // ========================================================
    // RESULT OBJECT FOR THIS TEST
    // ========================================================

    static class SolverResult {

        double price;
        double qd;
        double qs;
        int iterations;

        SolverResult(
                double price,
                double qd,
                double qs,
                int iterations) {

            this.price = price;
            this.qd = qd;
            this.qs = qs;
            this.iterations = iterations;
        }
    }
}