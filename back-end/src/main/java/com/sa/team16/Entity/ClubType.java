package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CLUBTYPE")
public class ClubType {

    @Id
    @SequenceGenerator(name = "clubType_seq", sequenceName = "clubType_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clubType_seq")
    @Column(name = "clubTypeId", unique = true, nullable = true)
    private Long clubTypeId;

    private @NonNull String clubTypeName;

    public void setClubType(String clubTypeName) {
        this.clubTypeName = clubTypeName;
    }
}