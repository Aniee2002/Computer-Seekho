package com.Project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Project.Entities.PaymentType;
import com.Project.Services.PaymentTypeService;

import java.util.List;

@RestController
@RequestMapping("/paymentTypes")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentService;


    @GetMapping("/getAll")
    public List<PaymentType> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/get")
    public String getPayment() {
        return "Hello";
    }
    
    @GetMapping("/{id}")
    public PaymentType getPaymentById(@PathVariable Integer id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/add")
    public PaymentType addPayment(@RequestBody PaymentType payment) {
        return paymentService.addPaymentType(payment);
    }
}
