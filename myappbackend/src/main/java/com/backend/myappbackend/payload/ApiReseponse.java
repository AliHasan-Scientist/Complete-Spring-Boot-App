package com.backend.myappbackend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ApiReseponse {
    public String message;
    public  Boolean success;
}
