package com.example.dto;

import java.time.LocalDate;

public class EiaObservationDTO {

    private LocalDate period;

    private double value;

    private double units;

    private String series;

    private String areaName; 

    private String processName; 

    private String seriesDescription;

    public LocalDate getPeriod() {
        return period;
    }
    public void setPeriod(LocalDate period) {
        this.period = period;   
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public double getUnits() {
        return units;
    }
    public void setUnits(double units) {
        this.units = units;
    }
    public String getSeries() {
        return series;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getProcessName() {
        return processName;
    }
    public void setProcessName(String processName) {
        this.processName = processName;
    }
    public String getSeriesDescription() {
        return seriesDescription;
    }
    public void setSeriesDescription(String seriesDescription) {
        this.seriesDescription = seriesDescription;
    }




    
}
