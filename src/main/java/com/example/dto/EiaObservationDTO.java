package com.example.dto;


import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EiaObservationDTO {

    private String period;

    private String duoarea; 

    private String productName; 

    private BigDecimal value;


    @JsonProperty("period")
    public String getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(String period) {
        this.period = period;
    }
    
 

    @JsonProperty("duoarea")
    public void setDuoarea(String duoarea) {
        this.duoarea = duoarea;
    }
    
    @JsonProperty("product_name")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("product_name")
    public void setProductName(String product_name) {
        this.productName = product_name;
    }

    @JsonProperty("value")
    public BigDecimal getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
    return "EiaObservationDTO{" +
            "period='" + period + '\'' +
            ", duoarea='" + duoarea + '\'' +
            ", product_name='" + productName + '\'' +
            ", value=" + value +
            '}';
    }


}