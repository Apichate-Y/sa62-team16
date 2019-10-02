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
public class Incomecontroller {

    @Autowired
    private final IncomeRepository incomeRepository;
    @Autowired
    private ExpentypeRepository expentypeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private ClubMemberRepository clubMemberRepository;

    Incomecontroller(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @GetMapping("/incomes")
    public Collection<Income> Incomes() {
        return incomeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/incomes/{expensename}/{clubmember_id}/{expid}/{cateid}/{stid}/{amount}")
    public Income newIncome(Income newincome, @PathVariable String expensename, @PathVariable long clubmember_id,
            @PathVariable long amount, @PathVariable long expid, @PathVariable long cateid, @PathVariable long stid) {

        ClubMember clubMember = clubMemberRepository.findById(clubmember_id);
        Expentype expentype = expentypeRepository.findById(expid);
        Category category = categoryRepository.findById(cateid);
        Status status = statusRepository.findById(stid);

        newincome.setClubMember(clubMember);
        newincome.setExpensename(expensename);
        newincome.setExp_id(expentype);
        newincome.setCate_id(category);
        newincome.setSt_id(status);
        newincome.setAmount(amount);

        return incomeRepository.save(newincome);
    }
}