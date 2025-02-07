package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Payment;

import jakarta.transaction.Transactional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Modifying
    @Transactional
    @Query(value="""
        update Student s set s.payment_due = s.payment_due - ?2 where s.student_id = ?1
    """,nativeQuery = true)
    void updatePaymentDue(int id, double amt);
}