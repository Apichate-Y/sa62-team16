package com.sa.team16.Repository;

import com.sa.team16.Entity.Activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActivityRepository extends JpaRepository<Activity, Long> {
	Activity findById(long ActivityId);
}