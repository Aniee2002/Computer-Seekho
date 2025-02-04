package com.Project.Services;

import com.Project.Entities.Placement;
import java.util.List;

public interface PlacementService {
    Placement createPlacement(Placement placement);
    Placement getPlacementById(int placementId);
    List<Placement> getAllPlacements();
    // List<Placement> getbyStudent(int studentID);
}
