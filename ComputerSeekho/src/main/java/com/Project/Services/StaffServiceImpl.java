package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Project.Entities.Staff;
import com.Project.Repositories.StaffRepository;
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Staff saveStaff(Staff staff) {
        staff.setStaffRole("ROLE_ADMIN");
        staff.setStaffUsername("rootuser");
        staff.setStaffPassword(passwordEncoder.encode("rootpassword"));
        return staffRepository.save(staff);
    }

    @Override
    public Staff findByStaffUsername(String staffUsername) {
        return staffRepository.findByStaffUsername(staffUsername).get();
    }

    

    @Override
    public boolean updateStaff(Staff staff) {
        
        if(isStaffExist(staff.getStaffId())) {
            String password = passwordEncoder.encode(staff.getStaffPassword());
            staff.setStaffPassword(password);
            staffRepository.updateStaff(staff.getStaffUsername(), password, staff.getStaffId());
            return true;
        }
            return false;
    }

    private boolean isStaffExist(int staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        return staff.isPresent();
    }

    @Override
    public boolean deleteByStaffUsername(String staffUsername) {
        Staff staff = staffRepository.findByStaffUsername(staffUsername).get();
        staffRepository.deleteByStaffUsername(staffUsername);
        if (staff == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
}
