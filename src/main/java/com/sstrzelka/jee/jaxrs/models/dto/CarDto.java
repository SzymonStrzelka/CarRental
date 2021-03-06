package com.sstrzelka.jee.jaxrs.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private float hp;
}
