package com.Project.Entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enquiry")
@Data
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enquiry_id")
    private int enquiryId;

    @Column(name = "enquirer_name")
    private String enquirerName;

    @Column(name = "enquirer_address")
    private String enquirerAddress;

    @Column(name = "enquirer_mobile")
    private String enquirerMobile;

    @Column(name = "enquirer_email_id")
    private String enquirerEmailId;

    @Column(name = "enquiry_date")
    private LocalDate enquiryDate;

    @Column(name = "enquirer_query")
    private String enquirerQuery;

    @Column(name = "course_name")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    private Staff staffId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "inquiry_counter")
    private int inquiryCounter;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;

    public int getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(int enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getEnquirerName() {
        return enquirerName;
    }

    public void setEnquirerName(String enquirerName) {
        this.enquirerName = enquirerName;
    }

    public String getEnquirerAddress() {
        return enquirerAddress;
    }

    public void setEnquirerAddress(String enquirerAddress) {
        this.enquirerAddress = enquirerAddress;
    }

    public String getEnquirerMobile() {
        return enquirerMobile;
    }

    public void setEnquirerMobile(String enquirerMobile) {
        this.enquirerMobile = enquirerMobile;
    }

    public String getEnquirerEmailId() {
        return enquirerEmailId;
    }

    public void setEnquirerEmailId(String enquirerEmailId) {
        this.enquirerEmailId = enquirerEmailId;
    }

    public LocalDate getEnquiryDate() {
        return enquiryDate;
    }

    public void setEnquiryDate(LocalDate enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    public String getEnquirerQuery() {
        return enquirerQuery;
    }

    public void setEnquirerQuery(String enquirerQuery) {
        this.enquirerQuery = enquirerQuery;
    }

    public String getCourseId() {
        return courseName;
    }

    public void setCourseId(String courseId) {
        this.courseName = courseId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getInquiryCounter() {
        return inquiryCounter;
    }

    public void setInquiryCounter(int inquiryCounter) {
        this.inquiryCounter = inquiryCounter;
    }

    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }
}