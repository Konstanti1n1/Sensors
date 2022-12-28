package com.example.progectSensors.DTO;

import java.util.List;

public class MeasurementResponse {
    public MeasurementResponse(List<MeasurementDTO> measurementDTOList) {
        this.measurementDTOList = measurementDTOList;
    }

    private  List<MeasurementDTO> measurementDTOList;

    public List<MeasurementDTO> getMeasurementDTOList() {
        return measurementDTOList;
    }

    public void setMeasurementDTOList(List<MeasurementDTO> measurementDTOList) {
        this.measurementDTOList = measurementDTOList;
    }
}
