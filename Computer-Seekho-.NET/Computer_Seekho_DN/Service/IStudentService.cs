using Computer_Seekho_DN.Models;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Service;

public interface IStudentService
{
    Task<ActionResult<IEnumerable<Student>>> GetAllStudents();
    Task<ActionResult<Student>> GetStudentById(int id);
    Task AddStudent(Student student);
    Task DeleteByStudentId(int studentId);
    Task<bool> UpdateStudent(Student student);
}