package com.sstrzelka.jee.jaxrs.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private final int id;
    private String brand;
    private String model;
    private float hp;
}
