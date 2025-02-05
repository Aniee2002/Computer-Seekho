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

    public int getBatch_id() {
        return batchId;
    }

    public void setBatch_id(int batch_id) {
        this.batchId = batch_id;
    }

    public String getBatch_name() {
        return batchName;
    }

    public void setBatch_name(String batch_name) {
        this.batchName = batch_name;
    }

    public LocalDate getBatch_start_time() {
        return batchStartTime;
    }

    public void setBatch_start_time(LocalDate batch_start_time) {
        this.batchStartTime = batch_start_time;
    }

    public LocalDate getBatch_end_time() {
        return batchEndTime;
    }

    public void setBatch_end_time(LocalDate batch_end_time) {
        this.batchEndTime = batch_end_time;
    }

    public int getCourse_id() {
        return course.getCourseId();
    }

    public void setCourse_id(int course_id) {
        this.course.setCourseId(course_id);
    }

    public Boolean getBatch_is_active() {
        return batchIsActive;
    }

    public void setBatch_is_active(Boolean batch_is_active) {
        this.batchIsActive = batch_is_active;
    }
}