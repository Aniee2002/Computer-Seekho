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

    private LocalDate batchEndTime;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "batch_is_active")
    private Boolean batchIsActive;
    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public LocalDate getBatch_start_time() {
        return batch_start_time;
    }

    public void setBatch_start_time(LocalDate batch_start_time) {
        this.batch_start_time = batch_start_time;
    }

    public LocalDate getBatch_end_time() {
        return batch_end_time;
    }

    public void setBatch_end_time(LocalDate batch_end_time) {
        this.batch_end_time = batch_end_time;
    }

    public int getCourse_id() {
        return course.getCourseId();
    }

    public void setCourse_id(int course_id) {
        this.course.setCourseId(course_id);
    }

    public boolean getBatch_is_active() {
        return batch_is_active;
    }

    public void setBatch_is_active(boolean batch_is_active) {
        this.batch_is_active = batch_is_active;
    }
}