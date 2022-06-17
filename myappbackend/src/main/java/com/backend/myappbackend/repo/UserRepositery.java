package com.backend.myappbackend.repo;

import com.backend.myappbackend.models.User;
import org.springframework.data.repository.CrudRepository;

import com.backend.myappbackend.models.User;

public interface UserRepositery extends CrudRepository<User, Integer> {

}
