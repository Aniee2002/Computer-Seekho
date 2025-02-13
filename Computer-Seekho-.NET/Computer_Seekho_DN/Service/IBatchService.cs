using Computer_Seekho_DN.Models;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Service
{
    public interface IBatchService
    {
        Task<ActionResult<Batch>?> GetBatchByBatchId(int BatchId);
        Task<ActionResult<IEnumerable<Batch>>> GetAllBatches();
        Task<ActionResult<Batch>> Add(Batch batch);
        Task<bool> Update(Batch batch);
        Task<bool> DeleteBatch(int batchId);
        
    }
}
