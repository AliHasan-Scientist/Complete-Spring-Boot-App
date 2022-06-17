package com.backend.myappbackend.exceptions;

import com.backend.myappbackend.payload.ApiReseponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice

public class GlobalResourceNotFoundException {

    @ExceptionHandler(ResourceNotFoundException.class)

    public ResponseEntity<ApiReseponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
        String mes = exception.getMessage();
        ApiReseponse apiReseponse = new ApiReseponse("message", false);

        return new ResponseEntity<ApiReseponse>(apiReseponse, HttpStatus.NOT_FOUND);
    }
@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> res = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((err) -> {
            String field = ((FieldError) err).getField();
            String message = err.getDefaultMessage();
            res.put(field, message);


        });

        return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
    }
}
