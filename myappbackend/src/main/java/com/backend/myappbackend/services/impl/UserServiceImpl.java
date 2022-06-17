package com.backend.myappbackend.services.impl;

import com.backend.myappbackend.exceptions.ResourceNotFoundException;
import com.backend.myappbackend.models.User;
import com.backend.myappbackend.payload.UserDto;
import com.backend.myappbackend.repo.UserRepositery;
import com.backend.myappbackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepositery userRepositery;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepositery.save(user);
        return this.userTodto(savedUser);

    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepositery.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepositery.save(user);
        UserDto userDto1 = this.userTodto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {

        User user = this.userRepositery.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserName", "userId", userId));


        return this.userTodto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = (List<User>) this.userRepositery.findAll();

        List<UserDto> userDtos = users.stream().map(user -> this.userTodto(user)).collect(Collectors.toList());
        return userDtos;

    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepositery.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
        this.userRepositery.delete(user);

    }

    //Model Mapper
    private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userTodto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
