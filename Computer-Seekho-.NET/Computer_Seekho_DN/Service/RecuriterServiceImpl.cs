using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Computer_Seekho_DN.Repository;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Computer_Seekho_DN.Models;

namespace Computer_Seekho_DN.Service
{
    public class RecruiterServiceImpl : IRecruiterService
    {
        private readonly ComputerSeekhoDbContext _context;

        public RecruiterServiceImpl(ComputerSeekhoDbContext context)
        {
            _context = context;
        }

        public async Task<ActionResult<IEnumerable<Recruiter>>> GetAllRecruiters()
        {
            var recruiters = await _context.Recruiters.ToListAsync();
            return new ActionResult<IEnumerable<Recruiter>>(recruiters);
        }

        public async Task<Recruiter> Add(Recruiter recruiter)
        {
            try
            {
                _context.Recruiters.Add(recruiter);
                await _context.SaveChangesAsync();
                return recruiter;
            }
            catch (Exception ex)
            {
                throw new Exception("Error adding recruiter: " + ex.Message);
            }
        }

        public async Task<bool> DeleteRecruiter(int id)
        {
            var recruiter = await _context.Recruiters.FindAsync(id);
            if (recruiter == null) return false;

            _context.Recruiters.Remove(recruiter);
            await _context.SaveChangesAsync();
            return true;
        }
    }
}