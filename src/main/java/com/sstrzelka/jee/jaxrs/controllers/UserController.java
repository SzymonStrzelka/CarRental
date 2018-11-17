package com.sstrzelka.jee.jaxrs.controllers;

import com.sstrzelka.jee.jaxrs.models.dto.UserDto;
import com.sstrzelka.jee.jaxrs.models.entities.User;
import com.sstrzelka.jee.jaxrs.services.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("users")
public class UserController {

    @Inject
    private UserService userService;

    @GET
    public Collection<User> getAllUsers() {
        return userService.getUserList();
    }

    @GET @Path("/{id}")
    public User getUser(@PathParam("id") int id) {
        return userService.getUser(id);
    }

    @POST
    public User createUser(@Valid UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @DELETE @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        userService.removeUser(id);
        return Response.noContent().build();
    }

    @PUT @Path("/{id}")
    public User updateUser(@PathParam("id") int id, @Valid UserDto userDto) {
        return userService.updateUser(id, userDto);
    }
}
