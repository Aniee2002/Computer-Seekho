package com.Project.Controllers;

import com.Project.Entities.ClosureReason;
import com.Project.Services.ClosureReasonService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/closureReasons")
public class ClosureReasonController {

    @Autowired
    private ClosureReasonService closureReasonService;

    @GetMapping("/{id}")
    public ResponseEntity<ClosureReason> getClosureReasonById(@PathVariable Integer id) {
        Optional<ClosureReason> closureReason2 = closureReasonService.getClosureReasonById(id);
        if (closureReason2.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(closureReason2.get());
        } {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping
    public ResponseEntity<ClosureReason> addClosureReason(@RequestBody ClosureReason closureReason) {
        ClosureReason closureReason2 = closureReasonService.addClosureReason(closureReason);
        return ResponseEntity.status(HttpStatus.CREATED).body(closureReason2);
    }
}


