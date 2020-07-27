package com.mesaj.pocs.demo.services;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User not found with Id " + id);
    }
}

