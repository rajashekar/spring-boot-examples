package com.udacity.bootstrap.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class DogNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 6451873330744060534L;

    public DogNotFoundException() {

    }

    public DogNotFoundException(String message) {
        super(message);
    }
}