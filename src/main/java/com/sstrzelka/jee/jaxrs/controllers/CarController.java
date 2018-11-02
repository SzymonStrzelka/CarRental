package com.sstrzelka.jee.jaxrs.controllers;

import com.sstrzelka.jee.jaxrs.models.dto.CarDto;
import com.sstrzelka.jee.jaxrs.models.entities.Car;
import com.sstrzelka.jee.jaxrs.services.CarService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("cars")
public class CarController {

    @Inject
    private CarService carService;

    @GET
    public Collection<Car> getAllCars(){
        return carService.getCarList();
    }

    @GET @Path("/{id}")
    public Car getCar(@PathParam("id") int id){
        return carService.getCar(id);
    }


    @POST @Consumes("application/json")
    public Car createCar(CarDto carDto){
        return carService.saveCar(carDto);
    }

    @DELETE @Path("/{id}")
    public Response deleteCar(@PathParam("id") int id){
        carService.removeCar(id);
        return Response.noContent().build();
    }

    @PUT @Path("/{id}")
    public Car updateCar(@PathParam("id") int id, CarDto carDto){
        return carService.updateCar(id, carDto);
    }
}
