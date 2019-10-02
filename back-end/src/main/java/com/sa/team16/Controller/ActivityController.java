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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private RegisterClubRepository registerClubRepository;
    @Autowired
    private TermRepository termRepository;
    @Autowired
    private TypeRepository typeRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/Activity")
    public Collection<Activity> activitys() {
        return activityRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/activity/{registerClubId}/{Activityname}/{TypeId}/{ActivityStartDATE}/{ActivityEndDATE}/{TermId}/{ActivityVenue}/{ActivityRecruits}")
    public Activity newActivity(Activity newActivity, @PathVariable long registerClubId, @PathVariable long TermId,
            @PathVariable long TypeId, @PathVariable String Activityname, @PathVariable String ActivityStartDATE,
            @PathVariable String ActivityEndDATE, @PathVariable String ActivityVenue,
            @PathVariable long ActivityRecruits) {

        RegisterClub registerclub = registerClubRepository.findById(registerClubId);
        Term term = termRepository.findById(TermId);
        Type type = typeRepository.findById(TypeId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate StartDate = LocalDate.parse(ActivityStartDATE, formatter);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate EndDate = LocalDate.parse(ActivityEndDATE, format);

        newActivity.setRegisterClub(registerclub);
        newActivity.setName(Activityname);
        newActivity.setType(type);
        newActivity.setStartDate(StartDate);
        newActivity.setEndDate(EndDate);
        newActivity.setTerm(term);
        newActivity.setVenue(ActivityVenue);
        newActivity.setRecrutis(ActivityRecruits);

        return activityRepository.save(newActivity);
    }

}