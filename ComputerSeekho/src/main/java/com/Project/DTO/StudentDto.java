package com.Project.DTO;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String photoUrl;
    private String name; 
    private String mobile;
    private String course;
    private String batch;
}