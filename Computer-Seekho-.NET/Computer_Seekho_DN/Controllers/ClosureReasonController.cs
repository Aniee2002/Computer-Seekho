using Microsoft.AspNetCore.Mvc;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Services;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Computer_Seekho_DN.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ClosureReasonController : ControllerBase
    {
        private readonly IClosureReasonService _closureReasonService;

        public ClosureReasonController(IClosureReasonService closureReasonService)
        {
            _closureReasonService = closureReasonService;
        }

        // GET: api/ClosureReason
        [HttpGet]
        public async Task<ActionResult<IEnumerable<ClosureReason>>> GetClosureReasons()
        {
            var closureReasons = await _closureReasonService.GetAllClosureReasons();
            return Ok(closureReasons);
        }

        // GET: api/ClosureReason/5
        [HttpGet("{id}")]
        public async Task<ActionResult<ClosureReason>> GetClosureReason(int id)
        {
            var closureReason = await _closureReasonService.GetClosureReasonById(id);

            if (closureReason == null)
            {
                return NotFound(new { message = "Closure reason not found." });
            }

            return Ok(closureReason);
        }

        // POST: api/ClosureReason
        [HttpPost]
        public async Task<ActionResult<ClosureReason>> PostClosureReason(ClosureReason closureReason)
        {
            if (closureReason == null)
            {
                return BadRequest(new { message = "Invalid data." });
            }

            var createdClosureReason = await _closureReasonService.AddClosureReason(closureReason);

            if (createdClosureReason == null)
            {
                return BadRequest(new { message = "Failed to add closure reason." });
            }

            return CreatedAtAction(nameof(GetClosureReason), new { id = createdClosureReason.ClosureReasonId }, createdClosureReason);
        }

        // DELETE: api/ClosureReason/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteClosureReason(int id)
        {
            var isDeleted = await _closureReasonService.DeleteClosureReason(id);

            if (!isDeleted)
            {
                return NotFound(new { message = "Closure reason not found." });
            }

            return NoContent();
        }
    }
}
