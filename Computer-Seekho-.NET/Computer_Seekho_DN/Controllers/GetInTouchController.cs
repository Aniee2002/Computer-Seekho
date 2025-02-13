using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Repository;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Computer_Seekho_DN.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class GetInTouchController : ControllerBase
    {
        private readonly ComputerSeekhoDbContext _context;

        public GetInTouchController(ComputerSeekhoDbContext context)
        {
            _context = context;
        }

        // GET: api/GetInTouch
        [HttpGet]
        public async Task<ActionResult<IEnumerable<GetInTouch>>> GetGetInTouch()
        {
            return await _context.GetInTouches.ToListAsync();
        }

        // GET: api/GetInTouch/5
        [HttpGet("{id}")]
        public async Task<ActionResult<GetInTouch>> GetGetInTouch(int id)
        {
            var getInTouch = await _context.GetInTouches.FindAsync(id);

            if (getInTouch == null)
            {
                return NotFound();
            }

            return getInTouch;
        }

        // PUT: api/GetInTouch/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutGetInTouch(int id, GetInTouch getInTouch)
        {
            if (id != getInTouch.GetInTouchId)
            {
                return BadRequest();
            }

            _context.Entry(getInTouch).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!GetInTouchExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/GetInTouch
        [HttpPost]
        public async Task<ActionResult<GetInTouch>> PostGetInTouch(GetInTouch getInTouch)
        {
            _context.GetInTouches.Add(getInTouch);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetGetInTouch", new { id = getInTouch.GetInTouchId }, getInTouch);
        }

        // DELETE: api/GetInTouch/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteGetInTouch(int id)
        {
            var getInTouch = await _context.GetInTouches.FindAsync(id);
            if (getInTouch == null)
            {
                return NotFound();
            }

            _context.GetInTouches.Remove(getInTouch);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool GetInTouchExists(int id)
        {
            return _context.GetInTouches.Any(e => e.GetInTouchId == id);
        }
    }
}