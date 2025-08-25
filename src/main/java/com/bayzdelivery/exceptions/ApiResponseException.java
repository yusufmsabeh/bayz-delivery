package com.bayzdelivery.exceptions;

import org.springframework.http.HttpStatus;

public class ApiResponseException extends RuntimeException {
    HttpStatus httpStatus;
    public ApiResponseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }
}
