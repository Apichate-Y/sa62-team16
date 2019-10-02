package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name = "PositionClub")
public class PositionClub {
	@Id
	@SequenceGenerator(name = "PositionClub_seq", sequenceName = "PositionClub_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PositionClub_seq")
	@Column(name = "PositionClub_ID", unique = true, nullable = true)
	private @NonNull Long positionclub_id;
	private @NonNull String positionclub_name;

}