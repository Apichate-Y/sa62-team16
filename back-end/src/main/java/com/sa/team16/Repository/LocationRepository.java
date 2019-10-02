package com.sa.team16.Repository;

import com.sa.team16.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource  
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findById(long locationId);
}