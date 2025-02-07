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

    @Column(name = "batch_is_active")
    private Boolean batchIsActive;

    @ManyToOne  
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;
  
}