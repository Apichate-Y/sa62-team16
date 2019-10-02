package com.sa.team16.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sa.team16.Repository.*;
import com.sa.team16.Entity.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CongenitalDiseaseController {

    @Autowired
    private final CongenitalDiseaseRepository congenitalDiseaseRepository;

    public CongenitalDiseaseController(CongenitalDiseaseRepository congenitalDiseaseRepository) {
        this.congenitalDiseaseRepository = congenitalDiseaseRepository;
    }

    @GetMapping("/CongenitalDisease")
    public Collection<CongenitalDisease> congenitalDiseases() {
        return congenitalDiseaseRepository.findAll().stream().collect(Collectors.toList());
    }

}