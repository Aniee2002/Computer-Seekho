package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.Batch;
import com.Project.Repositories.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService{

    @Autowired
    BatchRepository batchRepository;

    @Override
    public void addBatch(Batch b) {
        batchRepository.save(b);
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Optional<Batch> getByBatchName(String batchName) {
        return batchRepository.findByBatchName(batchName);
    }

    @Override
    public void delete(int batchId) {
        batchRepository.deleteById(batchId);
    }

    @Override
    public void activateBatch(int batchId,Boolean batchIsActive) {
        batchRepository.activateBatch(batchIsActive,batchId);
    }
    
}
