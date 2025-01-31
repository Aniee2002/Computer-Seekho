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

    @Override
    public Optional<Student> getStudentById(int studentId) {
        return studentRepositories.findById(studentId);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepositories.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepositories.save(student);
    }

    @Override
    public Student updateStudent(Student student,int studentId) {
        student.setStudentId(studentId);
        return studentRepositories.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepositories.deleteStudent(studentId);
    }

    @Override
    public List<Student> getbybatch(int batchId) {
        return studentRepositories.findByBatchId(batchId);
    }

    @Override
    public List<Student> getbycourse(int courseId) {
        return studentRepositories.findbycourse(courseId);
    }
}
