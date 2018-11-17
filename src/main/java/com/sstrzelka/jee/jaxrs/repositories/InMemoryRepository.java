package com.sstrzelka.jee.jaxrs.repositories;

import com.sstrzelka.jee.jaxrs.database.DataFiller;
import com.sstrzelka.jee.jaxrs.models.dto.CarDto;
import com.sstrzelka.jee.jaxrs.models.dto.CarRentalDto;
import com.sstrzelka.jee.jaxrs.models.dto.UserDto;
import com.sstrzelka.jee.jaxrs.models.entities.Car;
import com.sstrzelka.jee.jaxrs.models.entities.CarRental;
import com.sstrzelka.jee.jaxrs.models.entities.User;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.TreeMap;

@ApplicationScoped
public class InMemoryRepository implements Serializable {
    private final TreeMap<Integer, Car> carMap;
    private final TreeMap<Integer, CarRental> carRentalMap;
    private final TreeMap<Integer, User> userMap;

    InMemoryRepository() {
        DataFiller dataFiller = new DataFiller();
        carMap = dataFiller.fillCarData();
        userMap = dataFiller.fillUserData();
        carRentalMap = dataFiller.fillCarRentalsData(carMap, userMap);
    }

    Car getCar(int id) {
        return carMap.get(id);
    }

    Car updateCar(int id, CarDto carDto) {
        Car car = getCar(id);
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setHp(carDto.getHp());
        return car;
    }

    Car saveCar(CarDto carDto) {
        Car car = new Car(getEmptySafeNextKey(carMap), carDto.getBrand(), carDto.getModel(), carDto.getHp());
        carMap.put(car.getId(), car);
        return car;
    }

    void removeCar(int id) {

        carMap.remove(id);
        carRentalMap.values().removeIf(carRental -> carRental.getCar().getId() == id);
    }

    Collection<Car> getCarList() {
        return carMap.values();
    }

    User getUser(int id) {
        return userMap.get(id);
    }

    void removeUser(int id) {
        userMap.remove(id);
        carRentalMap.values().removeIf(carRental -> carRental.getUser().getId() == id);
    }

    User saveUser(UserDto userDto){
        User user = new User(getEmptySafeNextKey(userMap), userDto.getFirstName(), userDto.getLastName());
        userMap.put(user.getId(), user);
        return user;
    }

    Collection<User> getUserList() {
        return userMap.values();
    }

    User updateUser(int id, UserDto userDto) {
        User user = getUser(id);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }

    CarRental saveCarRental(CarRentalDto carRentalDto) {
        CarRental carRental = getCarRentalFromDto(getEmptySafeNextKey(carRentalMap), carRentalDto);
        carRentalMap.put(carRental.getId(), carRental);
        return carRental;
    }


    Collection<CarRental> getCarRentalList() {
        return carRentalMap.values();
    }

    void removeCarRental(int id) {
        carRentalMap.remove(id);
    }

    CarRental updateCarRental(int id, CarRentalDto carRentalDto) {
        CarRental carRental = getCarRentalFromDto(id, carRentalDto);
        carRentalMap.put(id, carRental);
        return carRental;
    }

    CarRental getCarRental(int id) {
        return carRentalMap.get(id);
    }

    private CarRental getCarRentalFromDto(int id, CarRentalDto carRentalDto) {
        return new CarRental(
                id,
                carRentalDto.getStartDate(),
                carRentalDto.getEndDate(),
                carRentalDto.getPrice(),
                getCar(carRentalDto.getCarId()),
                getUser(carRentalDto.getUserId()));
    }


    private <V> int getEmptySafeNextKey(TreeMap<Integer,V> map) {
        return map.isEmpty() ? 0 : map.lastKey() + 1;
    }
}