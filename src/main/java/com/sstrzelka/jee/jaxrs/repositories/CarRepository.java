package com.sstrzelka.jee.jaxrs.repositories;

import com.sstrzelka.jee.jaxrs.models.dto.CarDto;
import com.sstrzelka.jee.jaxrs.models.entities.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

@ApplicationScoped
public class CarRepository implements Serializable {

    @Inject
    private InMemoryRepository repository;

    public Collection<Car> getCarList(){
        return repository.getCarList();
    }

    public Car saveCar(CarDto carDto) {
        return repository.saveCar(carDto);
    }

    public void removeCar(int id) {
        repository.removeCar(id);
    }

    public Car updateCar(int id, CarDto carDto) {
        return repository.updateCar(id, carDto);
    }
}
