package com.sstrzelka.jee.jaxrs.services;

import com.sstrzelka.jee.jaxrs.models.dto.CarRentalDto;
import com.sstrzelka.jee.jaxrs.models.entities.CarRental;
import com.sstrzelka.jee.jaxrs.repositories.CarRentalRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class CarRentalService {

    @Inject
    private CarRentalRepository carRentalRepository;

    public Collection<CarRental> getCarRentalList() {
        return carRentalRepository.getCarRentalList();
    }

    public CarRental saveCarRental(CarRentalDto carRentalDto) {
        return carRentalRepository.saveCarRental(carRentalDto);
    }

    public void removeCarRental(int id) {
        carRentalRepository.removeCarRental(id);
    }

    public CarRental updateCarRental(int id, CarRentalDto carRentalDto) {
        return carRentalRepository.updateCarRental(id, carRentalDto);
    }

    public CarRental getCarRental(int id) {
        return carRentalRepository.getCarRental(id);
    }
}
