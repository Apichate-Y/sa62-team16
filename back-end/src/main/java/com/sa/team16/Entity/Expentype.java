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
@Table(name = "EXPENTYPE")
public class Expentype {
	@Id
	@SequenceGenerator(name = "expentype_seq", sequenceName = "expentype_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expentype_seq")
	@Column(name = "EXPENTYPE_ID", unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String typename;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Income> income;
}
