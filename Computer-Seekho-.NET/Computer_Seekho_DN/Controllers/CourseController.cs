using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Service;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Controllers;

[Route("api/Course")]
[ApiController]
public class CourseController : ControllerBase
{
    private readonly ICourseService _courseService;

    public CourseController(ICourseService courseService)
    {
        _courseService = courseService;
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<Course>> GetCourseById(int id)
    {
        var course = await _courseService.GetCourseById(id);
        if (course == null) return NotFound($"Course with ID {id} not found.");
        return course;
    }

    [HttpGet]
    public async Task<ActionResult<IEnumerable<Course>>> GetAllCourses()
    {
        return Ok(await _courseService.GetAllCourses());
    }

    [HttpPost]
    public async Task<ActionResult<Course>> AddCourse(Course course)
    {
        var createdCourse = await _courseService.AddCourse(course);
        return CreatedAtAction(nameof(GetCourseById), new { id = createdCourse.CourseId }, createdCourse);
    }

    [HttpPut("{id}")]
    public async Task<ActionResult<Course>> UpdateCourse(int id, Course course)
    {
        var updatedCourse = await _courseService.UpdateCourse(id, course);
        if (updatedCourse == null) return NotFound($"Course with ID {id} not found.");
        return Ok(updatedCourse);
    }

    [HttpDelete("{id}")]
    public async Task<ActionResult<Course>> DeleteCourse(int id)
    {
        var deletedCourse = await _courseService.DeleteCourse(id);
        if (deletedCourse == null) return NotFound($"Course with ID {id} not found.");
        return Ok(deletedCourse);
    }

    [HttpGet("search/{name}")]
    public async Task<ActionResult<Course>> FindCourseByName(string name)
    {
        var course = await _courseService.FindCourseByName(name);
        if (course == null) return NotFound($"Course with name '{name}' not found.");
        return course;
    }

}