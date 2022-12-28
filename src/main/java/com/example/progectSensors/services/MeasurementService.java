package com.example.progectSensors.services;

import com.example.progectSensors.model.Measurement;
import com.example.progectSensors.repositories.MeasurementRepositories;
import com.example.progectSensors.repositories.SensorRepositories;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepositories measurementRepositories;
    private final SensorRepositories sensorRepositories;

    @Autowired
    public MeasurementService(MeasurementRepositories measurementRepositories, SensorRepositories sensorRepositories) {
        this.measurementRepositories = measurementRepositories;
        this.sensorRepositories = sensorRepositories;
    }


    public List<Measurement> getMeasurement(){
        return measurementRepositories.findAll();
    }

    @Transactional
    public void save(Measurement measurement){
        enrichMeasurement(measurement);
        measurementRepositories.save(measurement);
    }

    public void enrichMeasurement(Measurement measurement){
            measurement.setSensor(sensorRepositories.findByName(measurement.getSensor().getName()).get());
    }
}
