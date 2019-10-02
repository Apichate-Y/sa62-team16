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

@Data
@Entity
@NoArgsConstructor
@Table(name = "INCOME")
public class Income {
    @Id
    @SequenceGenerator(name = "Income_seq", sequenceName = "Income_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Income_seq")
    @Column(name = "INCOME_ID", unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String expensename;
    private @NonNull Long amount;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Expentype.class)
    @JoinColumn(name = "EXPENTYPE_ID", insertable = true)
    private Expentype exp_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "CATEGORY_ID", insertable = true)
    private Category cate_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Status.class)
    @JoinColumn(name = "STATUS_ID", insertable = true)
    private Status st_id;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ClubMember.class)
    @JoinColumn(name = "CLUB_MEMBER_ID", insertable = true)
    private ClubMember clubMember;

}
