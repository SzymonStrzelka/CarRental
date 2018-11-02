package com.sstrzelka.jee.jaxrs.repositories;

import com.sstrzelka.jee.jaxrs.models.dto.CarDto;
import com.sstrzelka.jee.jaxrs.models.dto.CarRentalDto;
import com.sstrzelka.jee.jaxrs.models.entities.Car;
import com.sstrzelka.jee.jaxrs.models.entities.CarRental;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.TreeMap;

@ApplicationScoped
public class InMemoryRepository implements Serializable {
    private final TreeMap<Integer, Car> carMap = new TreeMap<>();
    private final TreeMap<Integer, CarRental> carRentalMap = new TreeMap<>();

    @PostConstruct
    private void fillData(){
        Car audi = new Car(1, "Audi", "A3", 120);
        Car bmw = new Car(2, "BWM", "320", 99.9f);
        Car mercedes = new Car(3, "Mercedes", "S-Class", 100);
        Car mazda = new Car(4, "Mazda", "6", 137.90f);
        carMap.put(audi.getId(), audi);
        carMap.put(bmw.getId(), bmw);
        carMap.put(mercedes.getId(), mercedes);
        carMap.put(mazda.getId(), mazda);

        carRentalMap.put(1,new CarRental(1, LocalDate.of(2018, 1, 1), LocalDate.of(2018,1,30), 190, audi));
        carRentalMap.put(2,new CarRental(2, LocalDate.of(2018, 11, 10), LocalDate.of(2018,12,31), 199.99f, mazda));
        carRentalMap.put(3,new CarRental(3, LocalDate.of(2017, 10, 1), LocalDate.of(2018,1,1), 250, mazda));
    }

    Collection<Car> getCarList(){
        return carMap.values();
    }
    Collection<CarRental> getCarRentalList() { return carRentalMap.values(); }

    Car saveCar(CarDto carDto) {
        Car car = new Car(carMap.lastKey() + 1, carDto.getBrand(), carDto.getModel(), carDto.getHp());
        carMap.put(car.getId(), car);
        return car;
    }

    CarRental saveCarRental(CarRentalDto carRentalDto){
        CarRental carRental = new CarRental(
                carRentalMap.lastKey() + 1,
                carRentalDto.getStartDate(),
                carRentalDto.getEndDate(),
                carRentalDto.getPrice(),
                getCar(carRentalDto.getCarId()));
        carRentalMap.put(carRental.getId(), carRental);
        return carRental;
    }

    Car getCar(int id){
        return carMap.get(id);
    }

    void removeCar(int id) {
        carMap.remove(id);
        carRentalMap.values().removeIf(carRental -> carRental.getCar().getId() == id);
    }
    void removeCarRental(int id) {carRentalMap.remove(id);}

    Car updateCar(int id, CarDto carDto) {
        Car car = carMap.get(id);
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setHp(carDto.getHp());
        return car;
    }

    CarRental updateCarRental(int id, CarRentalDto carRentalDto){
        CarRental carRental = new CarRental(id, carRentalDto.getStartDate(), carRentalDto.getEndDate(), carRentalDto.getPrice(), getCar(carRentalDto.getCarId()));
        carRentalMap.put(id, carRental);
        return carRental;
    }

    CarRental getCarRental(int id) {
        return carRentalMap.get(id);
    }
}
