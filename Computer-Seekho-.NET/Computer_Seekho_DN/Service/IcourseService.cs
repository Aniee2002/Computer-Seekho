using Computer_Seekho_DN.Models;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Service;

public interface ICourseService
{
    Task<ActionResult<Course>?> GetCourseById(int courseId);
    Task<ActionResult<IEnumerable<Course>>> GetAllCourses();
    Task<ActionResult<Course>> AddCourse(Course course);
    Task<Course> UpdateCourse(int courseId, Course course);
    Task<Course> DeleteCourse(int courseId);
    Task<ActionResult<Course>?> FindCourseByName(string courseName);

}