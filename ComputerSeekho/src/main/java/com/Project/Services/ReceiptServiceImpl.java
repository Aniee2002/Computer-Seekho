package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Project.Entities.Receipt;
import com.Project.Repositories.ReceiptRepositories;

public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    ReceiptRepositories receiptRepositories;
    @Override
    public Optional<Receipt> getReceiptById(int receiptId) {
        return receiptRepositories.findById(receiptId);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptRepositories.findAll();
    }

    @Override
    public Receipt addReceipt(Receipt receipt) {
        return receiptRepositories.save(receipt);
    }
}
