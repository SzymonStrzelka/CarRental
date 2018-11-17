package com.sstrzelka.jee.jaxrs.database;

import com.sstrzelka.jee.jaxrs.models.entities.Car;
import com.sstrzelka.jee.jaxrs.models.entities.CarRental;
import com.sstrzelka.jee.jaxrs.models.entities.User;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class DataFiller {
    public TreeMap<Integer, Car> fillCarData() {
        TreeMap<Integer, Car> carMap = new TreeMap<>();
        Car audi = new Car(1, "Audi", "A3", 120);
        Car bmw = new Car(2, "BWM", "320", 99.9f);
        Car mercedes = new Car(3, "Mercedes", "S-Class", 100);
        Car mazda = new Car(4, "Mazda", "6", 137.90f);
        carMap.put(audi.getId(), audi);
        carMap.put(bmw.getId(), bmw);
        carMap.put(mercedes.getId(), mercedes);
        carMap.put(mazda.getId(), mazda);
        return carMap;
    }

    public TreeMap<Integer, User> fillUserData() {
        TreeMap<Integer, User> userMap = new TreeMap<>();
        userMap.put(1, new User(1, "Jack", "Kowalsky"));
        userMap.put(2, new User(2, "John", "Wildback"));
        userMap.put(3, new User(3, "Frank", "Bigman"));
        return userMap;
    }

    public TreeMap<Integer, CarRental> fillCarRentalsData(Map<Integer, Car> carMap, Map<Integer, User> userMap) {
        TreeMap<Integer, CarRental> carRentalMap = new TreeMap<>();
        carRentalMap.put(1, new CarRental(1, LocalDate.of(2018, 1, 1), LocalDate.of(2018, 1, 30), 190, carMap.get(1), userMap.get(1)));
        carRentalMap.put(2, new CarRental(2, LocalDate.of(2018, 11, 10), LocalDate.of(2018, 12, 31), 199.99f, carMap.get(4), userMap.get(1)));
        carRentalMap.put(3, new CarRental(3, LocalDate.of(2017, 10, 1), LocalDate.of(2018, 1, 1), 250, carMap.get(4), userMap.get(2)));
        return carRentalMap;
    }
}
