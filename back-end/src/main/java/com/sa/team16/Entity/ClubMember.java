package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CLUB_MEMBER")
public class ClubMember {

    @Id
    @SequenceGenerator(name = "CLUB_MEMBER_SEQ", sequenceName = "CLUB_MEMBER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLUB_MEMBER_SEQ")
    @Column(name = "CLUB_MEMBER_ID", unique = true, nullable = true)

    private @NonNull Long id;
    private @NonNull String username;
    private @NonNull String password;
    private @NonNull Boolean statusmember;

    @Column(name = "REGISTER_DATE")
    private @NonNull Date registerDate;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "User_ID", insertable = true)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = RegisterClub.class)
    @JoinColumn(name = "RegisterClub_ID", insertable = true)
    private RegisterClub registerClub;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PositionClub.class)
    @JoinColumn(name = "PositionClub_ID", insertable = true)
    private PositionClub positionClub;

}