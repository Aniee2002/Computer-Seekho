package com.Project.Services;

import java.util.List;
import java.util.Optional;

import com.Project.Entities.Batch;


public interface BatchService {
    void addBatch(Batch b);
    List<Batch> getAllBatches();
    Optional<Batch> getByBatchName(String batch_name);
    void delete(int batch_id);
    void activateBatch(int batch_id,Boolean batch_is_active);
    
}
