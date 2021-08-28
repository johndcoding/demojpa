package com.johndcoding.demojpa.repositories;

import com.johndcoding.demojpa.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
