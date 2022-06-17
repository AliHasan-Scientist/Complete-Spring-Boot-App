package com.backend.myappbackend.services;


import com.backend.myappbackend.payload.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user ,Integer userId);

    UserDto getUserById( Integer userId);

    List<UserDto> getAllUser();

    void deleteUser(Integer userID);

}

