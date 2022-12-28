package com.example.progectSensors.controller;

import com.example.progectSensors.DTO.SensorDTO;
import com.example.progectSensors.mappers.SensorMapper;
import com.example.progectSensors.model.Sensor;
import com.example.progectSensors.services.SensorService;
import com.example.progectSensors.util.MeasurementError;
import com.example.progectSensors.util.SensorErrorException;
import com.example.progectSensors.util.SensorValidation;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.logging.Logger;


@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final SensorService sensorService;
    private final SensorValidation sensorValidation;

    private final ModelMapper modelMapper;



    @Autowired
    public SensorController(SensorService sensorService, SensorValidation sensorValidation, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.sensorValidation = sensorValidation;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public SensorDTO reverse(){
        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setName("dto");
        return sensorDTO;
    }


    @PostMapping("/registration")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<HttpStatus> registration(@RequestBody  @Valid SensorDTO sensorDTO, BindingResult br){
        Sensor sensor = convertToSensor(sensorDTO);
        sensorValidation.validate(sensor,br);
        if(br.hasErrors()) throw new SensorErrorException(br.getAllErrors().toString());
        sensorService.saveNewSensor(sensor);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<MeasurementError> errorRegistration(SensorErrorException e){
        MeasurementError response = new MeasurementError(e.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    private SensorDTO convertToSensorDTO(Sensor sensor){
        return modelMapper.map(sensor,SensorDTO.class);
    }

    public Sensor convertToSensor(SensorDTO sensorDTO){
        return modelMapper.map(sensorDTO,Sensor.class);
    }
}
