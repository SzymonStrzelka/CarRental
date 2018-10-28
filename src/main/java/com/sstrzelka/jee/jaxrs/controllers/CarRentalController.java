package com.sstrzelka.jee.jaxrs.controllers;

import com.sstrzelka.jee.jaxrs.models.dto.CarRentalDto;
import com.sstrzelka.jee.jaxrs.models.entities.CarRental;
import com.sstrzelka.jee.jaxrs.services.CarRentalService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("car-rentals")
public class CarRentalController {

    @Inject
    private CarRentalService carRentalService;

    @GET
    public Collection<CarRental> getAllCarRentals(){
        return carRentalService.getCarRentalList();
    }

    @POST
    @Consumes("application/json")
    public CarRental createCar(CarRentalDto carRentalDto){
        return carRentalService.saveCarRental(carRentalDto);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCarRental(@PathParam("id") int id){
        carRentalService.removeCarRental(id);
        return Response.noContent().build();
    }

    @PUT @Path("/{id}")
    public CarRental updateCarRental(@PathParam("id") int id, CarRentalDto carRentalDto){
        return carRentalService.updateCarRental(id, carRentalDto);
    }
}
