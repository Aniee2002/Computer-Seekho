package com.Project.Entities;

import jakarta.persistence.*; // Ensure correct imports for JPA annotations
import lombok.Data;

import org.springframework.stereotype.Component;

@Component
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int course_id;

    @Column(length = 100, name = "course_name") 
    private String coursename;

    @Column(length = 200, name = "course_descriptor") 
    private String coursedescription;

    @Column(name = "course_duration")
    private int courseduration;

    @Column(length = 200, name = "course_syllabus") 
    private String coursesyllabus;

    @Column(length = 100, name = "age_grp_type") 
    private String age_grp_type;

    @Column(name = "course_fee")
    private double coursefee;

    @Column(name = "course_is_active")
    private Boolean course_is_active;

    @Column(length = 100, name = "cover_photo") 
    private String coverphoto;

    @ManyToOne // Many courses can reference one video
    @JoinColumn(name = "video_id") 
    private Video videoid;

    // Getter and Setter Methods

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
    }

    public int getCourseduration() {
        return courseduration;
    }

    public void setCourseduration(int courseduration) {
        this.courseduration = courseduration;
    }

    public String getCoursesyllabus() {
        return coursesyllabus;
    }

    public void setCoursesyllabus(String coursesyllabus) {
        this.coursesyllabus = coursesyllabus;
    }

    public String getAge_grp_type() {
        return age_grp_type;
    }

    public void setAge_grp_type(String age_grp_type) {
        this.age_grp_type = age_grp_type;
    }

    public Boolean getCourse_is_active() {
        return course_is_active;
    }

    public void setCourse_is_active(Boolean course_is_active) {
        this.course_is_active = course_is_active;
    }

    public String getCoverphoto() {
        return coverphoto;
    }

    public void setCoverphoto(String coverphoto) {
        this.coverphoto = coverphoto;
    }

    public Video getVideoid() {
        return videoid;
    }

    public void setVideoid(Video videoid) {
        this.videoid = videoid;
    }
}