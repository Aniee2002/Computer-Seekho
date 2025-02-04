package com.Project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "placement")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placement_id")
    private int placementID;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student studentID;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", referencedColumnName = "recruiter_id")
    private Recruiter recruiterID;

    private int CTC;

    // Getters and Setters
    public int getPlacement_id() {
        return placementID;
    }

    public void setPlacement_id(int placement_id) {
        this.placementID = placement_id;
    }

    public Student getStudent() {
        return studentID;
    }

    public void setStudent(Student student) {
        this.studentID = student;
    }

    public Recruiter getRecruiter() {
        return recruiterID;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiterID = recruiter;
    }

    public int getCTC() {
        return CTC;
    }

    public void setCTC(int CTC) {
        this.CTC = CTC;
    }
}
