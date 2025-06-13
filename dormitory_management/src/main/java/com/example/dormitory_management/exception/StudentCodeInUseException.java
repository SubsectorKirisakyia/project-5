package com.example.dormitory_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN)
public class StudentCodeInUseException extends RuntimeException {
    public StudentCodeInUseException(String message) {
        super(message);
    }
}
