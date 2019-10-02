package com.sa.team16.Repository;

import com.sa.team16.Entity.CongenitalDisease;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CongenitalDiseaseRepository extends JpaRepository<CongenitalDisease, Long> {
    CongenitalDisease findById(long CongenitalDisease_ID);
}