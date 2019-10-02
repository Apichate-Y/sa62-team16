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
@Table(name = "STATUS")
public class Status {
	@Id
	@SequenceGenerator(name = "status_seq", sequenceName = "status_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_seq")
	@Column(name = "STATUS_ID", unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String statusname;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Income> income;

}
