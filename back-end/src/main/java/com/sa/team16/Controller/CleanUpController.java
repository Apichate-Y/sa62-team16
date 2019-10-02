package com.sa.team16.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CleanUpController {

    @Autowired
    private final CleanUpRepository cleanUpRepository;
    @Autowired
    private DayOfWeekRepository dayOfWeekRepository;
    @Autowired
    private ClubMemberRepository clubMemberRepository;
    @Autowired
    private DurationRepository durationRepository;

    CleanUpController(CleanUpRepository cleanUpRepository) {
        this.cleanUpRepository = cleanUpRepository;
    }

    @GetMapping("/cleanup")
    public Collection<CleanUp> CleanUps() {
        return cleanUpRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/cleanup/{clubmember_id}/{dayofweek_id}/{duration_id}/{note}")
    public CleanUp newCleanUp(CleanUp newCleanUp, @PathVariable long clubmember_id, @PathVariable long dayofweek_id,
            @PathVariable long duration_id, @PathVariable String note) {

        ClubMember clubMember = clubMemberRepository.findById(clubmember_id);
        DayOfWeek dayOfWeek = dayOfWeekRepository.findById(dayofweek_id);
        Duration duration = durationRepository.findById(duration_id);

        clubMember.setStatusmember(true);

        newCleanUp.setClubMember(clubMember);
        newCleanUp.setDayOfWeek(dayOfWeek);
        newCleanUp.setDuration(duration);
        newCleanUp.setNote(note);
        newCleanUp.setCleanupDate(new Date());

        return cleanUpRepository.save(newCleanUp);
    }
}