package com.sa.team16.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import com.sa.team16.Repository.*;
import com.sa.team16.Entity.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RegisterActivityController {

    @Autowired
    private final RegisterActivityRepository registerActivityRepository;
    @Autowired
    private ClubMemberRepository clubMemberRepository;
    @Autowired
    private ActivityRepository activityCreateRepository;
    @Autowired
    private CongenitalDiseaseRepository congenitalDiseaseRepository;

    RegisterActivityController(RegisterActivityRepository registerActivityRepository) {
        this.registerActivityRepository = registerActivityRepository;
    }

    @GetMapping("/RegisterActivity")
    public Collection<RegisterActivity> registerActivity() {
        return registerActivityRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/RegisterActivity/{ClubMember_ID}/{Activity_ID}/{PhoneNumber}/{CongenitalDisease_ID}/{FoodAllergic}")
    public RegisterActivity newRegisterActivity(RegisterActivity newRegisterActivity, @PathVariable long ClubMember_ID,
            @PathVariable long Activity_ID, @PathVariable String PhoneNumber, @PathVariable long CongenitalDisease_ID,
            @PathVariable String FoodAllergic) {

        ClubMember clubMember = clubMemberRepository.findById(ClubMember_ID);
        Activity activity = activityCreateRepository.findById(Activity_ID);
        CongenitalDisease congenitalDisease = congenitalDiseaseRepository.findById(CongenitalDisease_ID);

        newRegisterActivity.setClubMember(clubMember);
        newRegisterActivity.setActivity(activity);
        newRegisterActivity.setPhoneNumber(PhoneNumber);
        newRegisterActivity.setCongenitalDisease(congenitalDisease);
        newRegisterActivity.setFoodAllergic(FoodAllergic);

        return registerActivityRepository.save(newRegisterActivity);
    }
}