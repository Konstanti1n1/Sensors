package com.example.progectSensors.repositories;

import com.example.progectSensors.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepositories extends JpaRepository<Measurement,Integer> {
    List<Measurement> findBySensor(String str);
}
