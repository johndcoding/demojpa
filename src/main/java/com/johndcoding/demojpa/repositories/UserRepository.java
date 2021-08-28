package com.johndcoding.demojpa.repositories;

import com.johndcoding.demojpa.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
