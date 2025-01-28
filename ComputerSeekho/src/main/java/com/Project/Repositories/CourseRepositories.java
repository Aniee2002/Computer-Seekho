package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Project.Entities.Course;

@Repository
public interface CourseRepositories extends JpaRepository<Course, Integer> {
    
}
