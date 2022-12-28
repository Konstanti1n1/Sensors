package com.example.progectSensors.util;

import com.example.progectSensors.model.Measurement;
import com.example.progectSensors.services.MeasurementService;
import com.example.progectSensors.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidation implements Validator {

    private final MeasurementService measurementService;
    private final SensorService sensorService;

    @Autowired
    public MeasurementValidation(MeasurementService measurementService, SensorService sensorService) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Measurement measurement = (Measurement) target;

        if (!sensorService.checkNameUnique(measurement.getSensor().getName()))
            throw new MeasurementBadRequest("SensorName not found");
    }
}
