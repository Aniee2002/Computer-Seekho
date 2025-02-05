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
        System.out.print(b);
        batchRepository.save(b);
    }

    @Override
    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    @Override
    public Optional<Batch> getByBatchName(String batch_name) {
        return batchRepository.findByBatchName(batch_name);
    }

    @Override
    public void delete(int batch_id) {
        batchRepository.deleteById(batch_id);
    }

    @Override
    public void activateBatch(int batch_id,Boolean batch_is_active) {
        batchRepository.activateBatch(batch_is_active,batch_id);
    }
    
}
