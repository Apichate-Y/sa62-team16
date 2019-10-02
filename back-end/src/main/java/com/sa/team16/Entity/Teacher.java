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
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @Column(name = "teacherId", unique = true, nullable = true)
    private Long teacherId;

    private @NonNull String teacherName;

    public void setTeacher(String teacherName) {
        this.teacherName = teacherName;
    }
}