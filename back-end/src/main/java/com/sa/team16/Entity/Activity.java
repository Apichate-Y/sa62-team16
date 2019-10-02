package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Activity")
public class Activity {
	@Id
	@SequenceGenerator(name = "activity_create_seq", sequenceName = "activity_create_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_create_seq")
	@Column(name = "Activity_ID", unique = true, nullable = true)
	private @NonNull Long ActivityId;

	@Column(name = "ActivityStartDATE")
	private @NonNull LocalDate StartDate;

	@Column(name = "ActivityEndDATE")
	private @NonNull LocalDate EndDate;

	@Column(name = "Activityname", unique = true, nullable = true)
	private @NonNull String name;

	@Column(name = "ActivityVenue", unique = true, nullable = true)
	private @NonNull String venue;

	@Column(name = "ActivityRecruits", unique = true, nullable = true)
	private @NonNull Long recrutis;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = RegisterClub.class)
	@JoinColumn(name = "RegisterClub_ID", insertable = true)
	private RegisterClub registerClub;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
	@JoinColumn(name = "TypeId", insertable = true)
	private Type type;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Term.class)
	@JoinColumn(name = "TermId", insertable = true)
	private Term term;
}
