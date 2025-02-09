package com.Project.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.DTO.PaymentDTO;
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

    @Query("SELECT new com.Project.DTO.PaymentDTO(s.studentName, s.studentEmail, p.amount, p.paymentDate, pt.paymentTypeDesc) " +
    "FROM Payment p " +
    "JOIN p.student s " +
    "JOIN p.paymentTypeId pt " +
    "WHERE p.paymentId = :id")
    Optional<PaymentDTO> getPaymentOptional(@Param("id") int id);


    // @Query("SELECT new com.Project.DTO.PaymentDTO("+
    // "p.student.studentName, p.student.studentEmail, p.paymentTypeId.paymentTypeDesc, p.paymentId, p.amount,p.paymentDate)"+
    // "FROM Payment p "+
    // "JOIN p.student "+
    // "JOIN p.paymentTypeId "+
    // "WHERE p.paymentId = :id")
    // Optional<PaymentDTO> getPaymentOptional(@Param("id") int id);

    // @Query(value="""
    //         SELECT s.student_name, s.student_email, pt.payment_type_desc, p.payment_id, p.amount
    //         FROM student s
    //         JOIN payments p ON s.student_id = p.student_id
    //         JOIN payment_type pt ON p.payment_type_id = pt.payment_type_id
    //         WHERE p.payment_id = ?1
    //         """,nativeQuery = true)
    // Optional<PaymentDTO> getPaymentOptional(int paymentID); 
}