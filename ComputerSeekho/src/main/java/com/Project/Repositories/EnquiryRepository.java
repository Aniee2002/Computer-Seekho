package com.Project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Enquiry;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{
    @Query(value= """
    select * from Enquiry where Enquiry.staff_id = (select staff_id from staff where staff_username = :staffUsername) AND enquiry_is_active = true order by follow_up_date
    """ , nativeQuery = true)
    public List<Enquiry> getbystaffList(@Param(value = "staffUsername") String  staffUsername);

}