package com.example.progectSensors.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {

    @Column(name = "rain")
    private Boolean rain;
    @Column(name = "temperature")
    private Double temperature;

    @NotNull
    private SensorDTO Sensor;
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Boolean getRain() {
        return rain;
    }

    public void setRain(Boolean rain) {
        this.rain = rain;
    }

    public SensorDTO getSensor() {
        return Sensor;
    }

    public void setSensor(SensorDTO sensor) {
        Sensor = sensor;
    }
}
