package com.example.progectSensors.mappers;

import com.example.progectSensors.DTO.SensorDTO;
import com.example.progectSensors.model.Sensor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    //SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);

    SensorDTO convertToSensorDTO(Sensor person);
}
