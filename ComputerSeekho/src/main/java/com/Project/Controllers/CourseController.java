package com.Project.Controllers;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Course;
import com.Project.Services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(int id) {
        Optional<Course> course = courseService.getCourseById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(course.get());
    }
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course course2 = courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course2);
    }
    @PostMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        Course course2 = courseService.updateCourse(course, course.getCourse_id());
        return ResponseEntity.status(HttpStatus.CREATED).body(course2);
    }
    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<String> deleteCourse(int courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().body("Course Deleted");
    }
}
