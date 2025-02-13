using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Repository;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Computer_Seekho_DN.Exception;

namespace Computer_Seekho_DN.Service;

public class StudentService : IStudentService
{
    private readonly ComputerSeekhoDbContext _context;

    public StudentService(ComputerSeekhoDbContext context)
    {
        _context = context;
    }

    public async Task<ActionResult<IEnumerable<Student>>> GetAllStudents()
    {
        return await _context.Students
            .Include(s => s.Course)
            .Include(s => s.Batch)
            .Include(s => s.Payments)
            .ToListAsync();
    }

    public async Task<ActionResult<Student>> GetStudentById(int studentId)
    {
        Student? student = await _context.Students.FindAsync(studentId) ?? throw new NotFoundException($"Student not found with id {studentId}");
        return student;
    }

    public async Task AddStudent(Student student)
    {
        _context.Students.Add(student);
        await _context.SaveChangesAsync();
    }

    public async Task DeleteByStudentId(int studentId)
    {
        Student? student = await _context.Students.FindAsync(studentId) ?? throw new NotFoundException($"Student not found with id {studentId}");
        _context.Students.Remove(student);
        await _context.SaveChangesAsync();
    }

    public async Task<bool> UpdateStudent(Student student)
    {
        if (student == null)
        {
            return false;
        }

        _context.Entry(student).State = EntityState.Modified;

        await _context.SaveChangesAsync();
        return true;
    }
}