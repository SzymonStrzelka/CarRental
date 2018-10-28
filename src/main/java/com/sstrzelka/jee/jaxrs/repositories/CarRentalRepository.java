package com.sstrzelka.jee.jaxrs.repositories;

import com.sstrzelka.jee.jaxrs.models.dto.CarRentalDto;
import com.sstrzelka.jee.jaxrs.models.entities.CarRental;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class CarRentalRepository {

    @Inject
    private InMemoryRepository repository;

    public Collection<CarRental> getCarRentalList(){
        return repository.getCarRentalList();
    }

    public CarRental saveCarRental(CarRentalDto carRentalDto) {
        return repository.saveCarRental(carRentalDto);
    }

    public void removeCarRental(int id) {
        repository.removeCarRental(id);
    }

    public CarRental updateCarRental(int id, CarRentalDto carRentalDto) {
        return repository.updateCarRental(id, carRentalDto);
    }
}
