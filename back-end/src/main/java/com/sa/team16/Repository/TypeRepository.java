package com.sa.team16.Repository;

import com.sa.team16.Entity.Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findById(long TypeId);
}