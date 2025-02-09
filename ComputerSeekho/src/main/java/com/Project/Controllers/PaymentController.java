package com.Project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.Payment;
import com.Project.Services.PaymentService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }


    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createPayment(@RequestBody Payment payment) {
        if (payment.getStudent().getStudentId() < 0) {
            return new ResponseEntity<>(new ApiResponse("Student ID cannot be negative", LocalDateTime.now()), HttpStatus.BAD_REQUEST);
        }

        paymentService.savePayment(payment);
        return new ResponseEntity<>(new ApiResponse("Payment added successfully", LocalDateTime.now()), HttpStatus.CREATED);
    }
}

    // @PutMapping("/{id}")
    // public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment paymentDetails) {
    //     Payment payment = paymentService.getPaymentById(id);
    //     if (payment != null) {
    //         payment.setPaymentTypeId(paymentDetails.getPaymentTypeId());
    //         payment.setPaymentDate(paymentDetails.getPaymentDate());
    //         payment.setStudent(paymentDetails.getStudent());
    //         payment.setAmount(paymentDetails.getAmount());
    //         Payment updatedPayment = paymentService.updatePayment(payment);
    //         return ResponseEntity.ok(updatedPayment);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deletePayment(@PathVariable int id) {
    //     Payment payment = paymentService.getPaymentById(id);
    //     if (payment != null) {
    //         paymentService.deletePayment(id);
    //         return ResponseEntity.noContent().build();
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }



    //as we are not using update and delete payment methods in this project
    //we have commented them out
