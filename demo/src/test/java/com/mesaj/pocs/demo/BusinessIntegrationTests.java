package com.mesaj.pocs.demo;

import com.mesaj.pocs.demo.controllers.UserController;
import com.mesaj.pocs.demo.model.User;
import com.mesaj.pocs.demo.model.thirdparty.ThirdPartyUser;
import com.mesaj.pocs.demo.repositories.UserRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessIntegrationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;


    @Test
    public void givenUserIsAnAdultShouldBeRegistered() {

        Long userId = 1L;
        String name = "pepito";
        String lastName = "perez";

        ThirdPartyUser mockedUser = ThirdPartyUser
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .isAlive(true)
                .maritalStatus("single")
                .birthday(LocalDate.of(1960, Month.JANUARY, 1))
                .build();

        User userToRegister = User
                .builder()
                .firstName(name)
                .lastName(lastName)
                .id(userId)
                .username(name + lastName)
                .password("123456")
                .build();

        userController.save(userToRegister);
        Optional<User> userSaved = userRepository.findById(userId);

        assertThat(userSaved.isPresent(), equalTo(true));
    }
    @Test
    public void givenUserDoesNotExistShouldNotBeRegistered() {

        Long userId = 123L;
        String name = "pepito";
        String lastName = "perez";

        ThirdPartyUser mockedUser = ThirdPartyUser
                .builder()
                .id(userId)
                .firstName(name)
                .lastName(lastName)
                .isAlive(true)
                .maritalStatus("single")
                .birthday(LocalDate.of(1960, Month.JANUARY, 1))
                .build();

        User userToRegister = User
                .builder()
                .firstName(name)
                .lastName(lastName)
                .id(userId)
                .username(name + lastName)
                .password("123456")
                .build();

        userController.save(userToRegister);
        //Optional<User> userSaved = userRepository.findById(userId);

        //assertThat(userSaved.isPresent(), equalTo(true));
    }


}
