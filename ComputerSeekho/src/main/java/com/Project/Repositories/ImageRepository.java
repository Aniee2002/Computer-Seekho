package com.Project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image , Integer>
{

}