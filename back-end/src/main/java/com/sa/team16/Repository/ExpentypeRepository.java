package com.sa.team16.Repository;

import com.sa.team16.Entity.Expentype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExpentypeRepository extends JpaRepository<Expentype, Long> {
    Expentype findById(long id);
}