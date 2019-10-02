package com.sa.team16.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Date;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RegisterClubController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private final RegisterClubRepository registerClubRepository;

    RegisterClubController(RegisterClubRepository registerClubRepository) {
        this.registerClubRepository = registerClubRepository;
    }

    @GetMapping("/RegisterClub")
    public Collection<RegisterClub> RegisterClub() {
        return registerClubRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/RegisterClub/{teacher}/{location}/{club}")
    public RegisterClub newRegisterClub(RegisterClub newRegisterClub, @PathVariable long teacher,
            @PathVariable long location, @PathVariable long club) {

        Teacher teacherID = teacherRepository.findById(teacher);
        Location locationID = locationRepository.findById(location);
        Club clubID = clubRepository.findById(club);

        newRegisterClub.setDate(new Date());

        newRegisterClub.setTeacher(teacherID);
        newRegisterClub.setLocation(locationID);
        newRegisterClub.setClub(clubID);

        return registerClubRepository.save(newRegisterClub);
    }
}