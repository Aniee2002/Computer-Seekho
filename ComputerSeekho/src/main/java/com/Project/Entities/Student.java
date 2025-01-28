package com.Project.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_master")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name", length = 30, nullable = false)
    private String studentName;

    @Column(name = "student_address", length = 60)
    private String studentAddress;

    @Column(name = "student_gender", length = 10)
    private String studentGender;

    @Column(name = "photo_url", length = 255)
    private String photoUrl;

    @Column(name = "student_dob")
    private LocalDate studentDob;

    @Column(name = "student_qualification", length = 20)
    private String studentQualification;

    @Column(name = "student_mobile")
    private int studentMobile;

    @ManyToOne
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
    private Batch batch;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course_id;

    @Column(name = "student_password", length = 15, nullable = false)
    private String studentPassword;

    @Column(name = "student_username", length = 15, unique = true, nullable = false)
    private String studentUsername;
}