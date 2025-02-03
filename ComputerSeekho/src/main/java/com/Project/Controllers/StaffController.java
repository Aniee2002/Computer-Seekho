package com.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Staff;
import com.Project.Services.StaffService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/add")
    ResponseEntity<String> saveStaff(@RequestBody Staff staff) {
        Staff isAdded =  staffService.saveStaff(staff);
        if (isAdded != null) {
            return new ResponseEntity<>("Staff added successfully", HttpStatus.CREATED);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);     
        }
    }

    @PutMapping("/update")
    ResponseEntity<String> updateStaff(@RequestBody Staff staff) {
        boolean isUpdated = staffService.updateStaff(staff);
        if (isUpdated) {
            return new ResponseEntity<>("Staff updated successfully", HttpStatus.OK);
        } else {
            return  new ResponseEntity<>("Cannot Found Staff", HttpStatus.NOT_FOUND);     
        }
    }

    @GetMapping("/get/{staffUsername}")
    ResponseEntity<Staff> getStaff(@PathVariable String staffUsername) {
        Staff staff = staffService.findByStaffUsername(staffUsername);
        if (staff != null) {
            return new ResponseEntity<>(staff, HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);     
        }
    }

    @DeleteMapping("/delete/{staffUsername}")
    ResponseEntity<String> deleteStaff(@PathVariable String staffUsername) {
        boolean isDeleted = staffService.deleteByStaffUsername(staffUsername);
        if (isDeleted) {
            return new ResponseEntity<>("Staff deleted successfully", HttpStatus.OK);
        } else {
            return  new ResponseEntity<>("Staff Not Found with username "+staffUsername, HttpStatus.NOT_FOUND);     
        }
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Staff>> getAllStaff() {
        return new ResponseEntity<>(staffService.getAllStaff(),HttpStatus.FOUND);
    }
    
}
