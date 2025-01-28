package com.Project.Entities;

import java.util.Date;
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
    private int enquirerMobile;

    @Column(name = "enquirer_alternate_mobile")
    private int enquirerAlternateMobile;

    @Column(name = "enquirer_email_id")
    private String enquirerEmailId;

    @Column(name = "enquiry_date")
    private Date enquiryDate;

    @Column(name = "enquirer_query")
    private String enquirerQuery;

    @Column(name = "closure_reason_id")
    private int closureReasonId;

    @Column(name = "closure_reason")
    private String closureReason;

    @Column(name = "enquiry_processed_flag")
    private boolean enquiryProcessedFlag;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "inquiry_counter")
    private int inquiryCounter;

    @Column(name = "follow_up_date")
    private Date followUpDate;

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

    public int getEnquirerMobile() {
        return enquirerMobile;
    }

    public void setEnquirerMobile(int enquirerMobile) {
        this.enquirerMobile = enquirerMobile;
    }

    public int getEnquirerAlternateMobile() {
        return enquirerAlternateMobile;
    }

    public void setEnquirerAlternateMobile(int enquirerAlternateMobile) {
        this.enquirerAlternateMobile = enquirerAlternateMobile;
    }

    public String getEnquirerEmailId() {
        return enquirerEmailId;
    }

    public void setEnquirerEmailId(String enquirerEmailId) {
        this.enquirerEmailId = enquirerEmailId;
    }

    public Date getEnquiryDate() {
        return enquiryDate;
    }

    public void setEnquiryDate(Date enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    public String getEnquirerQuery() {
        return enquirerQuery;
    }

    public void setEnquirerQuery(String enquirerQuery) {
        this.enquirerQuery = enquirerQuery;
    }

    public int getClosureReasonId() {
        return closureReasonId;
    }

    public void setClosureReasonId(int closureReasonId) {
        this.closureReasonId = closureReasonId;
    }

    public String getClosureReason() {
        return closureReason;
    }

    public void setClosureReason(String closureReason) {
        this.closureReason = closureReason;
    }

    public boolean isEnquiryProcessedFlag() {
        return enquiryProcessedFlag;
    }

    public void setEnquiryProcessedFlag(boolean enquiryProcessedFlag) {
        this.enquiryProcessedFlag = enquiryProcessedFlag;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
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

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }
}