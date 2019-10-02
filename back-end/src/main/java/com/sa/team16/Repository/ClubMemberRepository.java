package com.sa.team16.Repository;

import com.sa.team16.Entity.ClubMember;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {
    ClubMember findById(long id);
}