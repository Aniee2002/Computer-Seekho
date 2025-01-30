package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Student;

@Repository
public interface StudentRepositories extends JpaRepository<Student, Integer> {
}
