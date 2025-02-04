package com.Project.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Project.Entities.Enquiry;
import com.Project.Repositories.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @Override
    public Enquiry createEnquiry(Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }

    @Override
    public Enquiry updateEnquiry(int enquiryId, Enquiry enquiry) {
        Optional<Enquiry> existingEnquiry = enquiryRepository.findById(enquiryId);
        if (existingEnquiry.isPresent()) {
            enquiry.setEnquiryId(enquiryId); 
            return enquiryRepository.save(enquiry);
        } else {
            throw new RuntimeException("Enquiry not found with ID: " + enquiryId);
        }
    }

    @Override
    public void deleteEnquiry(int enquiryId) {
        if(enquiryRepository.existsById(enquiryId)){
            enquiryRepository.deleteById(enquiryId);
        } else {
            throw new RuntimeException("Enquiry not found with ID: " + enquiryId);
        }
    }

    @Override
    public Enquiry getEnquiryById(int enquiryId) {
        return enquiryRepository.findById(enquiryId)
        .orElseThrow(() -> new RuntimeException("Enquiry not found with ID: " + enquiryId));
    }

    @Override
    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }

    @Override
    public List<Enquiry> getEnquiryByStaff(int staffId) {
        return enquiryRepository.getbystaffList(staffId);
    }
}
