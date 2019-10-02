package com.sa.team16.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
@Table(name = "RegisterActivity")
public class RegisterActivity {

    @Id
    @SequenceGenerator(name = "RegisterActivity_seq", sequenceName = "RegisterActivity_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RegisterActivity_seq")
    @Column(name = "RegisterActivity_ID", unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String PhoneNumber;
    private @NonNull String FoodAllergic;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ClubMember.class)
    @JoinColumn(name = "CLUB_MEMBER_ID", insertable = true)
    private ClubMember clubMember;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Activity.class)
    @JoinColumn(name = "Activity_ID", insertable = true)
    private Activity activity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CongenitalDisease.class)
    @JoinColumn(name = "CongenitalDisease_ID", insertable = true)
    private CongenitalDisease congenitalDisease;

}