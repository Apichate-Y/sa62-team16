package com.sa.team16.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ClubTypeController {

    @Autowired
    private final ClubTypeRepository clubTypeRepository;

    ClubTypeController(ClubTypeRepository clubTypeRepository) {
        this.clubTypeRepository = clubTypeRepository;
    }

    @GetMapping("/clubType")
    public Collection<ClubType> ClubType() {
        return clubTypeRepository.findAll().stream().collect(Collectors.toList());
    }

}