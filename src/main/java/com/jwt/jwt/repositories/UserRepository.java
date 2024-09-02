package com.jwt.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwt.jwt.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String login);

}
