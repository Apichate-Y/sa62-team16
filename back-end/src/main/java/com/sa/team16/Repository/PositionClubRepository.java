package com.sa.team16.Repository;

import com.sa.team16.Entity.PositionClub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionClubRepository extends JpaRepository<PositionClub, Long> {
    PositionClub findById(long positionclub_id);
}
