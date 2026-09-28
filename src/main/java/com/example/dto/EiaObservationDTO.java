package com.example.dto;

import java.time.LocalDate;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EiaObservationDTO {

    private String period;

    private String duoarea; 

    private String product_name; 

    private double value;


    @JsonProperty("period")
    public String getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(String period) {
        this.period = period;
    }
    
    @JsonProperty("duoarea")
    public String getDuoarea() {
        return duoarea;
    }

    @JsonProperty("duoarea")
    public void setDuoarea(String duoarea) {
        this.duoarea = duoarea;
    }
    
    @JsonProperty("product_name")
    public String getProduct_name() {
        return product_name;
    }

    @JsonProperty("product_name")
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @JsonProperty("value")
    public double getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
    return "EiaObservationDTO{" +
            "period='" + period + '\'' +
            ", duoarea='" + duoarea + '\'' +
            ", product_name='" + product_name + '\'' +
            ", value=" + value +
            '}';
    }


}