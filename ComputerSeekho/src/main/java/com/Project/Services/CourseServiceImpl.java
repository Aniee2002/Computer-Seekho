package com.Project.Services;

import java.util.List;
import java.util.Optional;

import com.Project.Entities.Course;
import com.Project.Repositories.CourseRepositories;

public class CourseServiceImpl implements CourseService {

    CourseRepositories courseRepositories;
    @Override
    public Optional<Course> getCourseById(int courseId) {
        return courseRepositories.findById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepositories.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepositories.save(course);
    }

    @Override
    public Course updateCourse(Course course, int courseId) {
        course.setCourse_id(courseId);
        return courseRepositories.save(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepositories.deleteById(courseId);
    }
    
}
