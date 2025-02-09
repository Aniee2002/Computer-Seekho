package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    boolean existsByStudentStudentId(int studentId); 
}

