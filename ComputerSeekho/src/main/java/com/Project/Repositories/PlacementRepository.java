package com.Project.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Project.Entities.Placement;

import jakarta.transaction.Transactional;
import java.util.List;


@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {
    
}