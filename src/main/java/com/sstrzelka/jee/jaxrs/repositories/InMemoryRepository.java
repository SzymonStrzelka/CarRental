package com.sstrzelka.jee.jaxrs.repositories;

import com.sstrzelka.jee.jaxrs.models.dto.CarDto;
import com.sstrzelka.jee.jaxrs.models.entities.Car;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.*;

@ApplicationScoped
public class InMemoryRepository implements Serializable {
    private final TreeMap<Integer, Car> carMap = new TreeMap<>();
    private final Set<Car> carRentalSet = new TreeSet<>(Comparator.comparingInt(Car::getId));

    @PostConstruct
    private void fillData(){
        carMap.put(1, new Car(1, "Audi", "A3", 120));
        carMap.put(2, new Car(2, "BWM", "320", 99.9f));
        carMap.put(3, new Car(3, "Mercedes", "S-Class", 100));
        carMap.put(4, new Car(4, "Mazda", "6", 137.90f));
    }

    Collection<Car> getCarList(){
        return carMap.values();
    }

    Car saveCar(CarDto carDto) {
        Car car = new Car(carMap.lastKey() + 1, carDto.getBrand(), carDto.getModel(), carDto.getHp());
        carMap.put(car.getId(), car);
        return car;

    }

    Car getCar(int id){
        return carMap.get(id);
    }

    void removeCar(int id) {
        carMap.remove(id);
    }

    Car updateCar(int id, CarDto carDto) {
        Car car = new Car(id, carDto.getBrand(), carDto.getModel(), carDto.getHp());
        carMap.put(id, car);
        return car;
    }
}
