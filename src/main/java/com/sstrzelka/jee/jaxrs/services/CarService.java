package com.sstrzelka.jee.jaxrs.services;

import com.sstrzelka.jee.jaxrs.models.dto.CarDto;
import com.sstrzelka.jee.jaxrs.models.entities.Car;
import com.sstrzelka.jee.jaxrs.repositories.CarRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;

@ApplicationScoped
public class CarService implements Serializable {

    @Inject
    private CarRepository carRepository;

    public Collection<Car> getCarList() {
        return carRepository.getCarList();
    }

    public Car saveCar(CarDto carDto) {
        return carRepository.saveCar(carDto);
    }

    public void removeCar(int id) {
        carRepository.removeCar(id);
    }

    public Car updateCar(int id, CarDto carDto) {
        return carRepository.updateCar(id, carDto);
    }
}
