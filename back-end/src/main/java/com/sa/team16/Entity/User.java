package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name = "User")
public class User {
	@Id
	@SequenceGenerator(name = "User_seq", sequenceName = "User_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_seq")
	@Column(name = "User_ID", unique = true, nullable = true)
	private @NonNull Long user_id;
	private @NonNull String id_student;
	private @NonNull String name;

}