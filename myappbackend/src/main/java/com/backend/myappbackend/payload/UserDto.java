package com.backend.myappbackend.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    private Integer id;
    @Deprecated
    @NotBlank(message = "name can not be empty")
    @Size(max = 5, message = "name >5", min = 3)
    private String name;

    @Email
    private String email;
    @NotBlank(message = "Not empty1")

    private String password;
    @NotBlank(message = "Not empty2")
    private String about;
}