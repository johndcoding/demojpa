package com.johndcoding.demojpa.rest;

import com.johndcoding.demojpa.entities.User;
import com.johndcoding.demojpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces("application/json")
    public Response  getAllUsers(){
        List<User> users = new ArrayList<>();
        Iterable<User> userIt = userRepository.findAll();
        userIt.forEach(users::add);
         return Response.status(200).entity(users).build();
    }

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public Response getAllUsers(@PathParam(value = "id") Long id){
        Optional<User> user = userRepository.findById(id);
        return Response.status(200).entity(user.orElseThrow(NotFoundException::new)).build();
    }

    @POST
    @Produces("application/json")
    public Response postUser(User user){
        User newUser = userRepository.save(user);
        return Response.status(201).entity(newUser).build();
    }


}
