package com.sa.team16.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ClubController {

    @Autowired
    private final ClubRepository clubRepository;
    @Autowired
    private ClubTypeRepository clubTypeRepository;

    ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @GetMapping("/Club")
    public Collection<Club> Club() {
        return clubRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Club/{clubName}/{clubDetail}/{clubType}")
    public Club newClub(Club newClub, @PathVariable String clubName, @PathVariable String clubDetail,
            @PathVariable long clubType) {

        ClubType ClubTypeID = clubTypeRepository.findById(clubType);

        newClub.setClubName(clubName);
        newClub.setClubDetail(clubDetail);
        newClub.setClubType(ClubTypeID);

        return clubRepository.save(newClub);
    }
}