package com.sa.team16.Controller;

import com.sa.team16.Entity.Expentype;
import com.sa.team16.Repository.ExpentypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Expentypecontroller {

    @Autowired
    private final ExpentypeRepository expentypeRepository;

    public Expentypecontroller(ExpentypeRepository expentypeRepository) {
        this.expentypeRepository = expentypeRepository;
    }

    @GetMapping("/expentype")
    public Collection<Expentype> Expentypes() {
        return expentypeRepository.findAll().stream().collect(Collectors.toList());
    }

}