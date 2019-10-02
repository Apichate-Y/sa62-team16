package com.sa.team16.Repository;

import com.sa.team16.Entity.Income;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IncomeRepository extends JpaRepository<Income, Long> {
	Income findById(long id);
}