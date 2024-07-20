package com.singhritik.backend.repository;

import com.singhritik.backend.model.User;
import com.singhritik.backend.model.ROLE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndRole(String username, ROLE role);
}
