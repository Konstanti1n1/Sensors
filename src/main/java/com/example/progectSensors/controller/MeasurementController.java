package com.example.progectSensors.controller;

import com.example.progectSensors.DTO.MeasurementDTO;
import com.example.progectSensors.DTO.MeasurementResponse;
import com.example.progectSensors.model.Measurement;
import com.example.progectSensors.services.MeasurementService;
import com.example.progectSensors.util.MeasurementBadRequest;
import com.example.progectSensors.util.MeasurementValidation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    private final MeasurementService measurementService;
    private final ModelMapper modelMapper;
    private final MeasurementValidation measurementValidation;
    private final Logger logger;

    public MeasurementController(MeasurementService measurementService, ModelMapper modelMapper, MeasurementValidation measurementValidation, Logger logger) {
        this.measurementService = measurementService;
        this.modelMapper = modelMapper;
        this.measurementValidation = measurementValidation;
        this.logger = logger;
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO, BindingResult br){
        Measurement measurement = convertToMeasurement(measurementDTO);
        measurementValidation.validate(measurement,br);
        if(br.hasErrors()) throw new MeasurementBadRequest(br.getAllErrors().toString());
        measurementService.save(measurement);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping()
    public MeasurementResponse getMeasurement(){
        return new MeasurementResponse(measurementService.getMeasurement().
                stream().map(this::convertToMeasurementDTO).
                collect(Collectors.toList()));
    }

    private MeasurementDTO convertToMeasurementDTO(Measurement measurement){
        return modelMapper.map(measurement, MeasurementDTO.class);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO){
        return modelMapper.map(measurementDTO, Measurement.class);
    }

}
