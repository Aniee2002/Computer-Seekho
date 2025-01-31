package com.Project.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Project.Services.StudentService;
import com.Project.Entities.Student;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(student.get());
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        // Student student = new Student();
        Student student2= studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student2);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student student2 = studentService.updateStudent(student, student.getStudentId());
        return ResponseEntity.status(HttpStatus.CREATED).body(student2);
    }

    @DeleteMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return "Student deleted with id: " + studentId;
    }

    @GetMapping("/bybatch/{batchid}")
    public List<Student> getbybatch(@PathVariable int batchid) {
        return studentService.getbybatch(batchid);
    }

    @GetMapping("/bycourse/{courseid}")
    public List<Student> getbycourse(@PathVariable int courseid) {
        return studentService.getbycourse(courseid);
    }
    
}
