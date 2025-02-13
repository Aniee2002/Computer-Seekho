using Computer_Seekho_DN.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Computer_Seekho_DN.Services
{
    public interface IClosureReasonService
    {
        Task<IEnumerable<ClosureReason>> GetAllClosureReasons();
        Task<ClosureReason> GetClosureReasonById(int id);
        Task<ClosureReason> AddClosureReason(ClosureReason closureReason);
        Task<bool> DeleteClosureReason(int id);
    }
}
