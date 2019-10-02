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
@Table(name = "CATEGORY")
public class Category {
	@Id
	@SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	@Column(name = "CATEGORY_ID", unique = true, nullable = true)
	private @NonNull Long id;
	private @NonNull String categoryname;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Income> income;

}
