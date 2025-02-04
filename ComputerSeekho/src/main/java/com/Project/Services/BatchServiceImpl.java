package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.Batch;
import com.Project.Repositories.BatchRepository;

import jakarta.transaction.Transactional;

@Service
public class BatchServiceImpl implements BatchService{

    @Autowired
    BatchRepository batchRepository;

    @Override
    public Batch addBatch(Batch b) {
       return batchRepository.save(b);
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
    public boolean delete(int batch_id) {

    Batch delete= batchRepository.findById(batch_id).get();
    if(delete==null)
    {
        return false;
    }
    batchRepository.deleteById(batch_id);
    return true;
    }
    @Override
    @Transactional
    public int deactivateBatch(int batch_id) {
        Optional<Batch> batchOptional = batchRepository.findById(batch_id);
        if (batchOptional.isPresent()) {
            batchRepository.updateBatchIsActive(batch_id);
            return 1;
             
        } else {
            return 0;
        }
    }
    @Override
    public List<Batch> getAllActiveBatches() {
        return batchRepository.findAllActiveBatch();
    }
    @Override
    public List<Batch> getByCourseId(int course_id) {
        return batchRepository.findByCourseId(course_id);
    }
    
}
