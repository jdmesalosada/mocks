package com.mesaj.pocs.thirdparty.repositories;

import com.mesaj.pocs.thirdparty.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
