package com.example.progectSensors.controller;

import com.example.progectSensors.DTO.SensorDTO;
import com.example.progectSensors.mappers.SensorMapper;
import com.example.progectSensors.model.Sensor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@AllArgsConstructor
public class HelloController {

    @Autowired
    private final SensorMapper sensorMapper;



    @ResponseBody
    @GetMapping("/hello")
    public SensorDTO hello(){

            Logger logger = Logger.getGlobal();

            Sensor person = new Sensor();
            person.setName("dan");

            logger.info("run");

            //return SensorMapper.INSTANCE.convertToSensorDTO(person);
            return sensorMapper.convertToSensorDTO(person);
        };
    }


