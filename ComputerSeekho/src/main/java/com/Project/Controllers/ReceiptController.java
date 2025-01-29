package com.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Receipt;
import com.Project.Services.ReceiptService;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getReceiptById(int receiptId) {
        Receipt receipt = receiptService.getReceiptById(receiptId).get();
        return ResponseEntity.status(HttpStatus.CREATED).body(receipt);
    }

    @GetMapping("/all")
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @PostMapping("/add")
    public ResponseEntity<Receipt> addReceipt(Receipt receipt) {
        Receipt receipt2 = receiptService.addReceipt(receipt);
        return ResponseEntity.status(HttpStatus.CREATED).body(receipt2);
    }
}