package com.sstrzelka.jee.jaxrs.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String brand;
    private String model;
    private float hp;
}
