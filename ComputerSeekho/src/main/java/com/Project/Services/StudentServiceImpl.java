package com.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Project.Entities.Student;
import com.Project.Repositories.StudentRepositories;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepositories studentRepositories;

    public Optional<Student> getStudentById(int studentId) {
        return studentRepositories.findById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepositories.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepositories.save(student);
    }
    public Student updateStudent(Student student,int studentId) {
        student.setStudentId(studentId);
        return studentRepositories.save(student);
    }
    public void deleteStudent(int studentId) {
        studentRepositories.deleteById(studentId);
    }
}
