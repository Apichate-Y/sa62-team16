package com.sa.team16.Controller;

import com.sa.team16.Entity.DayOfWeek;
import com.sa.team16.Repository.DayOfWeekRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DayOfWeekController {

    @Autowired
    private final DayOfWeekRepository dayOfWeekRepository;

    public DayOfWeekController(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    @GetMapping("/dayofweek")
    public Collection<DayOfWeek> DayOfWeeks() {
        return dayOfWeekRepository.findAll().stream().collect(Collectors.toList());
    }

}