package com.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Placement;
import com.Project.Services.PlacementService;

@RestController
@RequestMapping("/placement")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Placement> getPlacement(@PathVariable int id) {
        Placement placement = placementService.getPlacementById(id);
        if(placement == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(placement);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Placement>> getAllPlacements() {
        List<Placement> placements = placementService.getAllPlacements();
        if(placements == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(placements);
    }

    // @GetMapping("/student/{studentId}")
    // public ResponseEntity<Iterable<Placement>> getPlacementsByStudent(@PathVariable int studentId) {
    //     Iterable<Placement> placements = placementService.getbyStudent(studentId);
    //     if(placements == null) {
    //         return ResponseEntity.status(404).body(null);
    //     }
    //     return ResponseEntity.status(200).body(placements);
    // }

    @PostMapping("/add")
    public ResponseEntity<Placement> addPlacement(@PathVariable Placement placement) {
        Placement placement2 = placementService.createPlacement(placement);
        if(placement2 == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(placement2);
    }
}
