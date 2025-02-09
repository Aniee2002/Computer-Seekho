package com.Project.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "closure_reason")
@Data
public class ClosureReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "closure_reason_id")
    private int closureReasonId;

    @Column(name = "closure_reason_desc")
    private String closureReasonDesc;

    @Column(name= "enquirer_name")
    private String enquirerName;

}
