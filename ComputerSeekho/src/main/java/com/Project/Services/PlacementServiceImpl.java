package com.Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Project.Entities.Placement;
import com.Project.Repositories.PlacementRepository;

public class PlacementServiceImpl implements PlacementService {
    @Autowired
    private PlacementRepository placementRepository;

    @Override
    public Placement createPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public Placement getPlacementById(int placementId) {
        return placementRepository.findById(placementId).get();
    }

    @Override
    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    @Override
    public List<Placement> getbyStudent(int studentID) {
        return placementRepository.findByStudentID(studentID);
    }
}
