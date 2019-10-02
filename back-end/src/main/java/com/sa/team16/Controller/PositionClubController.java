package com.sa.team16.Controller;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PositionClubController {

    @Autowired
    private final PositionClubRepository positionClubRepository;

    public PositionClubController(PositionClubRepository positionClubRepository) {
        this.positionClubRepository = positionClubRepository;
    }

    @GetMapping("/positionClub")
    public Collection<PositionClub> positionClubs() {
        return positionClubRepository.findAll().stream().collect(Collectors.toList());
    }

}