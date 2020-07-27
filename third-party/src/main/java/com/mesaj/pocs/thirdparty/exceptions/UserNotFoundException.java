package com.mesaj.pocs.thirdparty.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User not found with Id " + id);
    }
}
