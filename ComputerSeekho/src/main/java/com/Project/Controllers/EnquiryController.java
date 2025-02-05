package com.Project.Controllers;

import com.Project.Entities.Enquiry;
import com.Project.Services.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("null")
@RequestMapping("/enquiries")
public class EnquiryController {

    @Autowired
    public EnquiryService enquiryService;
    
    @PostMapping("/create")
    public Enquiry createEnquiry(@RequestBody Enquiry enquiry) {
        return enquiryService.createEnquiry(enquiry);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        List<Enquiry> enquries =  enquiryService.getAllEnquiries();
        if (enquries != null) {
            return new ResponseEntity<>(enquries, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);     
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Enquiry> updateEnquiry(@PathVariable int id, @RequestBody Enquiry enquiry) {
        Enquiry newEnquiry = enquiryService.getEnquiryById(id);
        if (newEnquiry == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(enquiryService.updateEnquiry(id, enquiry));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEnquiry(@PathVariable int id) {
        enquiryService.deleteEnquiry(id);
        return new ResponseEntity<>("Enquiry deleted successfully", HttpStatus.OK);
    }

    @GetMapping("getid/{id}")
    public ResponseEntity<Enquiry> getEnquiryById(@PathVariable int id) {
        Enquiry enquiry =  enquiryService.getEnquiryById(id);
        if (enquiry == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(enquiry, HttpStatus.OK);
    }

    @GetMapping("getbystaff/{staffId}")
    public ResponseEntity<List<Enquiry>> getEnquiryByStaff(@PathVariable int staffId) {
        List<Enquiry> enquries =  enquiryService.getEnquiryByStaff(staffId);
        if (enquries != null) {
            return new ResponseEntity<>(enquries, HttpStatus.OK);
        }
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);    
    }
}
