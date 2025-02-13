using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Computer_Seekho_DN.Models;

namespace Computer_Seekho_DN.Service
{
    public interface IRecruiterService
    {
        Task<bool> DeleteRecruiter(int id);
        Task<ActionResult<IEnumerable<Recruiter>>> GetAllRecruiters();
        Task<Recruiter> Add(Recruiter record);
    }
}