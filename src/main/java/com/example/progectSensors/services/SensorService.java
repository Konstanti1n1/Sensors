package com.example.progectSensors.services;

import com.example.progectSensors.model.Sensor;
import com.example.progectSensors.repositories.SensorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepositories sensorRepositories;

    @Autowired
    public SensorService(SensorRepositories sensorRepositories) {
        this.sensorRepositories = sensorRepositories;
    }


    @Transactional
    public void saveNewSensor(Sensor sensor){
        sensorRepositories.save(sensor);
    }


    public Boolean checkNameUnique(String name){
        Optional<Sensor> sensor = sensorRepositories.findByName(name);
        if (sensor.isPresent()) return true;
        else return false;
    }


}
