using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Repository;
using Computer_Seekho_DN.Service;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

public class CourseService : ICourseService
{
    private readonly ComputerSeekhoDbContext _context;

    public CourseService(ComputerSeekhoDbContext context)
    {
        _context = context;
    }

    public async Task<ActionResult<Course>> GetCourseById(int courseId)
    {
        var course = await _context.Courses.FindAsync(courseId);
        if (course == null) return new NotFoundResult();
        return course;
    }

    public async Task<ActionResult<IEnumerable<Course>>> GetAllCourses()
    {
        var courses = await _context.Courses.ToListAsync();
        return new ActionResult<IEnumerable<Course>>(courses);
    }

    public Task<ActionResult<Course>> AddCourse(Course course)
    {
        throw new NotImplementedException();
    }

    public Task<Course> UpdateCourse(int courseId, Course course)
    {
        throw new NotImplementedException();
    }

    public Task<Course> DeleteCourse(int courseId)
    {
        throw new NotImplementedException();
    }

    public Task<ActionResult<Course>> FindCourseByName(string courseName)
    {
        throw new NotImplementedException();
    }

    // Fixed the incomplete method declaration
    public async Task<ActionResult<Course>> SomeMethodName()
    {
        throw new NotImplementedException();
    }
}
