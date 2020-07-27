package com.mesaj.pocs.thirdparty.controllers;

import com.mesaj.pocs.thirdparty.exceptions.UserNotFoundException;
import com.mesaj.pocs.thirdparty.models.User;
import com.mesaj.pocs.thirdparty.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{id}")
    User getById(@PathVariable Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
