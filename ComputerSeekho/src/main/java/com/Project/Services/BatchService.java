package com.Project.Services;

import java.util.List;
import java.util.Optional;

import com.Project.Entities.Batch;


public interface BatchService {
    Batch addBatch(Batch b);
    List<Batch> getAllBatches();
    Optional<Batch> getByBatchName(String batch_name);
    boolean delete(int batch_id);
    int deactivateBatch(int batch_id);
    List<Batch> getAllActiveBatches();
    List<Batch> getByCourseId(int course_id);

}
