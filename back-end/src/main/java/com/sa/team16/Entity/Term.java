package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TERM")
public class Term {
    @Id
    @SequenceGenerator(name = "Term_seq", sequenceName = "Term_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Term_seq")
    @Column(name = "TermId", unique = true, nullable = true)
    private @NonNull Long TermId;
    private @NonNull String Termname;

}