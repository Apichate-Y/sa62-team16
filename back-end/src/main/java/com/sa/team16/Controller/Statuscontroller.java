package com.sa.team16.Controller;

import com.sa.team16.Entity.Status;
import com.sa.team16.Repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Statuscontroller {

    @Autowired
    private final StatusRepository statusRepository;

    public Statuscontroller(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping("/statuse")
    public Collection<Status> Statuss() {
        return statusRepository.findAll().stream().collect(Collectors.toList());
    }

}