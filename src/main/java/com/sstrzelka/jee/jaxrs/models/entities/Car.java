package com.sstrzelka.jee.jaxrs.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Car {
    private final int id;
    private final String brand;
    private final String model;
    private final float hp;
}
