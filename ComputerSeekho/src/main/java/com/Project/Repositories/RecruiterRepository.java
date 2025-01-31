package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter,Integer> {
    
}
