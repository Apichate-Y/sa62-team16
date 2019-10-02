package com.sa.team16.Repository;

import com.sa.team16.Entity.DayOfWeek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Long> {
    DayOfWeek findById(long id);
}