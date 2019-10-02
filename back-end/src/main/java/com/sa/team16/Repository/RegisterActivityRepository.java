package com.sa.team16.Repository;

import com.sa.team16.Entity.RegisterActivity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RegisterActivityRepository extends JpaRepository<RegisterActivity, Long> {

}