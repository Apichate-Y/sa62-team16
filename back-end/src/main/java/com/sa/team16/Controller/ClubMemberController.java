package com.sa.team16.Controller;

import com.sa.team16.Entity.*;
import com.sa.team16.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ClubMemberController {

    @Autowired
    private final ClubMemberRepository clubMemberRepository;
    @Autowired
    private RegisterClubRepository registerClubRepository;
    @Autowired
    private PositionClubRepository positionClubRepository;
    @Autowired
    private UserRepository userRepository;

    public ClubMemberController(ClubMemberRepository clubMemberRepository) {
        this.clubMemberRepository = clubMemberRepository;
    }

    @GetMapping("/clubmember")
    public Collection<ClubMember> ClubMembers() {
        return clubMemberRepository.findAll().stream().filter(s -> s.getStatusmember().equals(false))
                .collect(Collectors.toList());
    }

    @GetMapping("/clubmember/{id}")
    public Optional<ClubMember> ClubMembers(@PathVariable Long id) {
        Optional<ClubMember> clubmember = clubMemberRepository.findById(id);
        return clubmember;
    }

    @GetMapping("/clubmember/{username}/{password}")
    public Collection<ClubMember> ClubMembers(@PathVariable String username, @PathVariable String password) {
        return clubMemberRepository.findAll().stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .collect(Collectors.toList());
    }

    @PostMapping("/clubmember/{username}/{password}/{User_id}/{RegisterClub_id}/{PositionClub_id}")
    public ClubMember newclubMember(ClubMember newclubMember, @PathVariable String username,
            @PathVariable String password, @PathVariable long RegisterClub_id, @PathVariable long PositionClub_id,
            @PathVariable long User_id) {

        User user = userRepository.findById(User_id);
        RegisterClub registerClub = registerClubRepository.findById(RegisterClub_id);
        PositionClub positionClub = positionClubRepository.findById(PositionClub_id);

        newclubMember.setUser(user);
        newclubMember.setRegisterClub(registerClub);
        newclubMember.setPositionClub(positionClub);
        newclubMember.setUsername(username);
        newclubMember.setPassword(password);
        newclubMember.setRegisterDate(new Date());

        return clubMemberRepository.save(newclubMember);
    }
}
