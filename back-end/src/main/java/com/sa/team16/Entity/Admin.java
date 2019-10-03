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
@Table(name = "Admin")
public class Admin {
	@Id
	@SequenceGenerator(name = "Admin_seq", sequenceName = "Admin_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Admin_seq")
	@Column(name = "Admin_ID", unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String adminusername;
	private @NonNull String adminpassword;

}