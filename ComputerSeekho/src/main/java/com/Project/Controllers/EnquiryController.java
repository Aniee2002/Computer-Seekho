package com.Project.Controllers;

import com.Project.Entities.Enquiry;
import com.Project.Services.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquiries")
public class EnquiryController {

    @Autowired
    public EnquiryService enquiryService;

    @PostMapping("/create")
    public Enquiry createEnquiry(@RequestBody Enquiry enquiry) {
        return enquiryService.createEnquiry(enquiry);
    }

    @GetMapping("/getAll")
    public List<Enquiry> getAllEnquiries() {
        return enquiryService.getAllEnquiries();
    }

    @PutMapping("/update/{id}")
    public Enquiry updateEnquiry(@PathVariable int id, @RequestBody Enquiry enquiry) {
        return enquiryService.updateEnquiry(id, enquiry);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEnquiry(@PathVariable int id) {
        enquiryService.deleteEnquiry(id);
    }

    @GetMapping("getid/{id}")
    public Enquiry getEnquiryById(@PathVariable int id) {
        return enquiryService.getEnquiryById(id);
    }
}

