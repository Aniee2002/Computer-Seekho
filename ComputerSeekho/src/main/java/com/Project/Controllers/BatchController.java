package com.Project.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Batch;
import com.Project.Services.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @PostMapping("/add")
    public ResponseEntity<Batch> addBatch(Batch b)
    {
        batchService.addBatch(b);
        return ResponseEntity.ok(b);
    }

    @GetMapping("/all")
    public List<Batch> getAllBatches()
    {
        return batchService.getAllBatches();
    }
    
    @GetMapping("/get/{batch_name}")
    public ResponseEntity<Batch> getByBatchName(@PathVariable String batch_name)
    {
        Optional<Batch> batch = batchService.getByBatchName(batch_name);
        if(batch.isPresent())
        {
            return ResponseEntity.ok(batch.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{batch_id}")
    public ResponseEntity<String> delete(@PathVariable int batch_id)
    {
        batchService.delete(batch_id);
        return ResponseEntity.ok("Batch Deleted");
    }

    @PutMapping("/activate/{batch_id}/{batch_is_active}")
    public ResponseEntity<String> activateBatch(@PathVariable int batch_id,@PathVariable Boolean batch_is_active)
    {
        batchService.activateBatch(batch_id,batch_is_active);
        return ResponseEntity.ok("Batch Activated / Deactivates");
    }
    

}
