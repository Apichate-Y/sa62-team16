package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Date;

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
@Table(name = "RegisterClub")
public class RegisterClub {

    @Id
    @SequenceGenerator(name = "RegisterClub_seq", sequenceName = "RegisterClub_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegisterClub_seq")
    @Column(name = "RegisterClub_ID", unique = true, nullable = true)
    private Long registerClubId;

    @Column(name = "DATE")
    private @NonNull Date Date;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Teacher.class)
    @JoinColumn(name = "teacherId", insertable = true)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Location.class)
    @JoinColumn(name = "locationId", insertable = true)
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Club.class)
    @JoinColumn(name = "clubId", insertable = true)
    private Club club;

}