package com.Project.Controllers;

import java.time.LocalDateTime;
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
import com.Project.DTO.ApiResponse;
import com.Project.DTO.StudentDto;
import com.Project.Entities.Student;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(student.get());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        if(students == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Student added successfully", null));
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student student2 = studentService.updateStudent(student, student.getStudentId());
        return ResponseEntity.status(HttpStatus.CREATED).body(student2);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(new ApiResponse("Student deleted with id: " + studentId, LocalDateTime.now()),HttpStatus.OK);
    }

    @GetMapping("/getbybatch/{batchid}")
    public ResponseEntity<List<Student>> getbybatch(@PathVariable int batchid) {
        List<Student> students = studentService.getbybatch(batchid);
        if(students == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(students); 
    }

    @GetMapping("/getbycourse/{courseid}")
    public ResponseEntity<List<Student>> getbycourse(@PathVariable int courseid) {
        List<Student> students = studentService.getbycourse(courseid);
        if(students == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(students);
    }
    
}
