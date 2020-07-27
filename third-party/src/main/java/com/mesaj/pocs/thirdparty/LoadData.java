package com.mesaj.pocs.thirdparty;

import com.mesaj.pocs.thirdparty.models.User;
import com.mesaj.pocs.thirdparty.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
@Slf4j
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            log.info("Preloading " + userRepository.save(
                    User
                            .builder()
                            .firstName("goku")
                            .lastName("sayayin")
                            .maritalStatus("married")
                            .isAlive(true)
                            .birthday(LocalDate.of(1960, Month.JANUARY, 1))
                            .build()
                    )
            );

            log.info("Preloading " + userRepository.save(
                    User
                            .builder()
                            .firstName("prometheus")
                            .lastName("jobs")
                            .maritalStatus("single")
                            .isAlive(true)
                            .birthday(LocalDate.of(1900, Month.JANUARY, 1))
                            .build()
                    )
            );

            log.info("Preloading " + userRepository.save(
                    User
                            .builder()
                            .firstName("yisus")
                            .lastName("sayayin")
                            .maritalStatus("single")
                            .isAlive(true)
                            .birthday(LocalDate.of(1900, Month.DECEMBER, 1))
                            .build()
                    )
            );
        };
    }
}
