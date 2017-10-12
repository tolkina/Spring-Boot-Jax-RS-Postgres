package com.example.rest.controller;

import com.example.rest.exception.UserAlreadyExistException;
import com.example.rest.exception.UserNotFoundException;
import com.example.rest.model.User;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    public Response createUser(User user) throws UserAlreadyExistException {
        userService.createUser(user);
        return Response.status(201).entity(user).build();
    }

    @GET
    public Response retrieveAllUsers() {
        List<User> users = userService.retrieveAllUsers();
        return Response.status(200).entity(users).build();
    }

    @GET
    @Path("{id}")
    public Response retrieveUser(@PathParam("id") Long id) throws UserNotFoundException {
        User user = userService.retrieveUser(id);
        return Response.status(200).entity(user).build();
    }

}
