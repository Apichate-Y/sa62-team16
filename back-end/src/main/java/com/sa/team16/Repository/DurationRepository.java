package com.sa.team16.Repository;

import com.sa.team16.Entity.Duration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DurationRepository extends JpaRepository<Duration, Long> {
    Duration findById(long id);
}