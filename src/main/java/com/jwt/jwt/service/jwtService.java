package com.jwt.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.jwt.entities.jwtEntitie;
import com.jwt.jwt.repositories.jwtRepository;

@Service
public class jwtService {

    @Autowired
    private jwtRepository repo;

    public List<jwtEntitie> getAll() {
        return repo.findAll();
    }

    public jwtEntitie set(jwtEntitie obj) {
        return repo.save(obj);
    }
}
