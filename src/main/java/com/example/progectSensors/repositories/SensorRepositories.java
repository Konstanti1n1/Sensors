package com.example.progectSensors.repositories;

import com.example.progectSensors.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorRepositories extends JpaRepository<Sensor,Integer> {
    Optional<Sensor>findByName(String name);
}
