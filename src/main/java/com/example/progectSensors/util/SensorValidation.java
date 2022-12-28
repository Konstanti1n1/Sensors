package com.example.progectSensors.util;

import com.example.progectSensors.model.Sensor;
import com.example.progectSensors.repositories.SensorRepositories;
import com.example.progectSensors.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
@Component
public class SensorValidation implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidation(SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;

        if(sensorService.checkNameUnique(sensor.getName()))
            errors.rejectValue("name","","Sensor name busy ");


    }
}
