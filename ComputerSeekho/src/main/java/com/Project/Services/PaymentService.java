package com.Project.Services;

import com.Project.Entities.Payment;
import java.util.List;

public interface PaymentService {
    Payment getPaymentById(int paymentId);
    List<Payment> getAllPayments();
    Payment savePayment(Payment payment);
    Payment updatePayment(Payment payment);
    void deletePayment(int paymentId);
}