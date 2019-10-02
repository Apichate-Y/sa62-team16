package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name = "CongenitalDisease")
public class CongenitalDisease {
	@Id
	@SequenceGenerator(name = "CongenitalDisease_seq", sequenceName = "CongenitalDisease_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CongenitalDisease_seq")
	@Column(name = "CongenitalDisease_ID", unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String CongenitalDisease;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<RegisterActivity> register;
}
