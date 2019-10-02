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
@Table(name = "LOCATION")
public class Location {

    @Id
    @SequenceGenerator(name = "location_seq", sequenceName = "location_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
    @Column(name = "locationId", unique = true, nullable = true)
    private Long locationId;

    private @NonNull String locationName;

    public void setLocation(String locationName) {
        this.locationName = locationName;
    }
}