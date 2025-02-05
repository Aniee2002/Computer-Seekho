package com.Project.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "batch")
@Data
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")
    private int batchId;

    @Column(name = "batch_name")
    private String batchName;

    @Column(name = "batch_start_time")
    private LocalDate batchStartTime;

    @Column(name = "batch_end_time")
    private LocalDate batchEndTime;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "batch_is_active")
    private Boolean batchIsActive;

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public LocalDate getBatchStartTime() {
        return batchStartTime;
    }

    public void setBatchStartTime(LocalDate batchStartTime) {
        this.batchStartTime = batchStartTime;
    }

    public LocalDate getBatchEndTime() {
        return batchEndTime;
    }

    public void setBatchEndTime(LocalDate batchEndTime) {
        this.batchEndTime = batchEndTime;
    }

    // public Course getCourse() {
    //     return course;
    // }

    // public void setCourse(Course course) {
    //     this.course = course;
    // }

    public Boolean getBatchIsActive() {
        return batchIsActive;
    }

    public void setBatchIsActive(Boolean batchIsActive) {
        this.batchIsActive = batchIsActive;
    }

    public int getCourseId(){
        return course.getCourseId();
    }

    public void setCourseId(int courseId){
        course.setCourseId(courseId);
    }
}