package com.johndcoding.demojpa.rest;

import com.johndcoding.demojpa.entities.Task;
import com.johndcoding.demojpa.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/tasks")
public class TaskResource {

    @Autowired
    private TaskRepository taskRepository;

    @GET
    @Produces("application/json")
    public List<Task> getAllTasks(){
        List<Task> tasks = new ArrayList<>();
        Iterable<Task> taskIt = taskRepository.findAll();
        taskIt.forEach(tasks::add);
         return tasks;
    }

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public Task getAllTasks(@PathParam(value = "id") Long id){
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(NotFoundException::new);
    }

}
