package com.Project.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "followup")
@Data
public class Followup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followup_id")
    private int followup_id;

    @ManyToOne
    @JoinColumn(name = "enquiry_id", referencedColumnName = "enquiry_id")
    private Enquiry enquiry;

    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    private Staff staff;

    @Column(name = "followup_date")
    private LocalDate followup_date;

    @Column(name = "followup_msg")
    private String followup_msg;

    @Column(name = "is_active")
    private boolean is_active;

    public void setFollowupId(int followup_id){
        this.followup_id = followup_id;
    }

    public int getFollowupId(){
        return followup_id;
    }

    public int getEnquiryId() {
        return enquiry.getEnquiryId();
    }

    public void setEnquiryId(int enquiry_id) {
        this.enquiry.setEnquiryId(enquiry_id);
    }

    public int getStaffId() {
        return staff.getStaffId();
    }

    public void setStaffId(int staff_id) {
        this.staff.setStaffId(staff_id);
    }

    public void setFollowupDate(LocalDate followup_date){
        this.followup_date = followup_date;
    }

    public LocalDate getFollowupDate(){
        return followup_date;
    }

    public void setFollowupMsg(String followup_msg){
        this.followup_msg = followup_msg;
    }

    public String getFollowupMsg(){
        return followup_msg;
    }

    public void setActive(boolean is_active){
        this.is_active = is_active;
    }

    public Boolean getActive(){
        return is_active;
    }   
}