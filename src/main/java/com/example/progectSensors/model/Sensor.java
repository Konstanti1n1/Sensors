package com.example.progectSensors.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sensor")
@NamedQueries({@NamedQuery(name = "Sensor.findByIdOne", query ="from Sensor where id = ?")})
@NamedNativeQueries({@NamedNativeQuery(name = "Sensor.findByIdSecond", query = "select * from Sensor where id = ?", resultClass = Sensor.class)})
@Setter
@Getter
public class Sensor implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    @NotNull
    private String name;

    public Sensor(){}

}
