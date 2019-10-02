package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CLUB")
public class Club {

    @Id
    @SequenceGenerator(name = "clubs_seq", sequenceName = "clubs_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clubs_seq")
    @Column(name = "clubId", unique = true, nullable = true)
    private Long clubId;

    private @NonNull String clubName;
    private @NonNull String clubDetail;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ClubType.class)
    @JoinColumn(name = "clubTypeId", insertable = true)
    private ClubType clubType;
}