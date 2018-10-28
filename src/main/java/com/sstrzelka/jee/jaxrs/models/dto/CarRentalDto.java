package com.sstrzelka.jee.jaxrs.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRentalDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private float price;
    private int carId;
}
