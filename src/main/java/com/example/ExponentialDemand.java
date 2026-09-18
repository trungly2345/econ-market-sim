package com.example;

    public class ExponentialDemand implements DemandModel {


        private double baseDemand;
        private double decayRate;

        public ExponentialDemand(double baseDemand, double decayRate) {
            this.baseDemand = baseDemand;
            this.decayRate = decayRate;
        }

        public double getBaseDemand() {
            return baseDemand;
        }

        public void setBaseDemand(double baseDemand) {
            this.baseDemand = baseDemand;
        }

        public double getDecayRate() {
            return decayRate;
        }

        public void setDecayRate(double decayRate) {
            this.decayRate = decayRate;
        }


        @Override
        public double calculateQuantityDemanded(double price) {
            double result = baseDemand * Math.exp(-decayRate * price);
            return Math.max(0,result);
        }
        
    }