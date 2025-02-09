package com.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.DTO.StudentDto;
import com.Project.Entities.Student;
import com.Project.Repositories.StudentRepositories;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepositories studentRepositories;

    @Override
    public Optional<Student> getStudentById(int studentId) {
        return studentRepositories.findById(studentId);
    }

    @Override
    public List<StudentDto> getAllStudents() {
       return studentRepositories.findAll().stream()
       .map(student -> new StudentDto(student.getStudentId(),student.getPhotoUrl(),student.getStudentName()
       ,student.getStudentMobile(),student.getCourse().getCourseName(),student.getBatch().getBatchName())).collect(Collectors.toList());
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
        studentRepositories.deleteById(studentId);
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
