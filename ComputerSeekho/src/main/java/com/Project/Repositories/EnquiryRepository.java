package com.Project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Enquiry;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{
    @Query(value= """
    select * from Enquiry where Enquiry.staff_id = ?1 AND Enquiry.follow_up_date = CURDATE()
    """ , nativeQuery = true)
    public List<Enquiry> getbystaffList(int staffId);
}