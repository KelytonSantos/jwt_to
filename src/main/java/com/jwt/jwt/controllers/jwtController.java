package com.jwt.jwt.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jwt.jwt.entities.jwtEntitie;
import com.jwt.jwt.service.jwtService;

@Controller
@RequestMapping(value = "/all")
public class jwtController {

    @Autowired
    private jwtService serv;

    @GetMapping
    public ResponseEntity<List<jwtEntitie>> getAll() {
        List<jwtEntitie> obj = serv.getAll();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<jwtEntitie> insert(@RequestBody jwtEntitie obj) {
        obj = serv.set(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
