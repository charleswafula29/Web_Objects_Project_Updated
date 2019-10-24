package com.example.project;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    // to be able to pass your message with your exception
    public NotFoundException(String message) {
        super(message);
    }
}