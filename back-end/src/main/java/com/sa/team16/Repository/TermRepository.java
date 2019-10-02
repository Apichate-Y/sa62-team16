package com.sa.team16.Repository;

import com.sa.team16.Entity.Term;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TermRepository extends JpaRepository<Term, Long> {
    Term findById(long TermId);
}