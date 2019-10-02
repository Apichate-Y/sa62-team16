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
@Table(name = "TYPE")
public class Type {
    @Id
    @SequenceGenerator(name = "Type_seq", sequenceName = "Type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Type_seq")
    @Column(name = "TypeId", unique = true, nullable = true)
    private @NonNull Long TypeId;
    private @NonNull String Typename;

}
