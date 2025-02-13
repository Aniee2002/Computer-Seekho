using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Computer_Seekho_DN.Service;
using Computer_Seekho_DN.Models;

namespace Computer_Seekho_DN.Controllers;

[Route("api/[controller]")]
[ApiController]
public class StudentController : ControllerBase
{
    private readonly IStudentService _studentService;

    public StudentController(IStudentService studentService)
    {
        _studentService = studentService;
    }

    [HttpGet]
    public async Task<ActionResult<IEnumerable<Student>>> GetAllStudents()
    {
        return Ok(await _studentService.GetAllStudents());
    }

    [HttpDelete("{studentId}")]
    public async Task<ActionResult> DeleteByStudentId(int studentId)
    {
        await _studentService.DeleteByStudentId(studentId);
        return Ok(new { message = "Student deleted successfully." });
    }

    [HttpPost]
    public async Task<ActionResult> AddStudent(Student student)
    {
        _studentService.AddStudent(student);
        return Ok(new { message = "Student added successfully." });
    }

}