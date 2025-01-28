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
        throw new UnsupportedOperationException("Unimplemented method 'getReceiptById'");
    }

    @Override
    public List<Receipt> getAllReceipts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllReceipts'");
    }

    @Override
    public Receipt addReceipt(Receipt receipt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addReceipt'");
    }
    
}
