package com.jwt.jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.jwt.entities.jwtEntitie;

public interface jwtRepository extends JpaRepository<jwtEntitie, Long> {

}
