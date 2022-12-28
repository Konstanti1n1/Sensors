package com.example.progectSensors.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
@Component
@Setter
@Getter
public class SensorDTO {
    @Column(name = "name")
    @NotEmpty
    private String name;



}


