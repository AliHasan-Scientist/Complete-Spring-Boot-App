package com.backend.myappbackend.controllers;


import com.backend.myappbackend.payload.ApiReseponse;
import com.backend.myappbackend.payload.UserDto;
import com.backend.myappbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // create a new user
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Validated @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return (new ResponseEntity<>(createUserDto, HttpStatus.CREATED));
    }

    // Put
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Validated @RequestBody UserDto userDto, @PathVariable Integer userId) {
        UserDto updateUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }

    //Delete User
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<ApiReseponse> deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiReseponse("user Deleted Succesfully",true), HttpStatus.ACCEPTED);
    }

    //Get All users
    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDto>> getAllUser() {

        return (ResponseEntity.ok(userService.getAllUser()));
    }

    //Get user by id
    @GetMapping(value = "/getUser/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId) {
        UserDto userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }
}