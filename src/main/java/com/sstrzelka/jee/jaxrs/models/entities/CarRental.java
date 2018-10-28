package com.sstrzelka.jee.jaxrs.models.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CarRental {
    private final int id;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final float price;
}
