using System.Web;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Service;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Controllers;

[Route("[controller]")]
[ApiController]
public class StaffController : ControllerBase
{
    private readonly IstaffService _staffService;

    public StaffController(IstaffService staffService)
    {
        _staffService = staffService;
    }
    
    // GET: api/staff
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Staff>>> GetAllStaff()
    {
        return await _staffService.GetAllStaff();
    }

    // GET: api/staff/{id}
    [HttpGet("{id}")]
    public async Task<ActionResult<Staff>> GetStaff(int id)
    {
        var staff = await _staffService.GetStaff(id);
        if (staff == null)
        {
            return NotFound(new { message = "Staff not found" });
        }
        return staff;
    }

    // POST: api/staff
    [HttpPost]
    public async Task<ActionResult<Staff>> AddStaff([FromBody] Staff staff)
    {
        if (staff == null)
        {
            return BadRequest(new { message = "Invalid staff data" });
        }

        var newStaff = await _staffService.Add(staff);
        return CreatedAtAction(nameof(GetStaff), new { id = newStaff.StaffId }, newStaff);
    }

    // PUT: api/staff/{id}
    [HttpPut("{id}")]
    public async Task<IActionResult> UpdateStaff([FromBody] Staff staff)
    {
        var updatedStaff = await _staffService.Update(staff);
        if (updatedStaff == null)
        {
            return NotFound(new { message = "Staff not found for update" });
        }

        return Ok(updatedStaff);
    }

    // DELETE: api/staff/{id}
    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteStaff(int id)
    {
        bool result = await _staffService.DeleteStaff(id);
        if (!result)
        {
            return NotFound(new { message = "Staff not found for deletion" });
        }
        return NoContent();
    }

    // GET: api/staff/username/{username}
    [HttpGet("username/{username}")]
    public async Task<ActionResult<int>> GetStaffIdByUsername(string username)
    {
        try
        {
            int staffId = await _staffService.getStaffIdByStaffUsername(username);
            return Ok(staffId);
        }
        catch (Exception)
        {
            return NotFound(new { message = "Staff not found by username" });
        }
    }
}
