using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Repository;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Computer_Seekho_DN.Service
{
    public class BatchService : IBatchService
    {
        private readonly ComputerSeekhoDbContext computerSeekhoDbContext;

        public BatchService(ComputerSeekhoDbContext computerSeekhoDbContext)
        {
            this.computerSeekhoDbContext = computerSeekhoDbContext;
        }
        public async Task<ActionResult<Batch>> Add(Batch batch)
        {
            computerSeekhoDbContext.Add(batch);
            await computerSeekhoDbContext.SaveChangesAsync();
            return batch;
        }

        public async Task<bool> DeleteBatch(int batchId)

        {

            Batch batch = computerSeekhoDbContext.Batches.Find(batchId);

            if (batch != null)

            {

                computerSeekhoDbContext.Batches.Remove(batch);

                await computerSeekhoDbContext.SaveChangesAsync();

                return true;

            }

            return false;



        }

        public async Task<ActionResult<IEnumerable<Batch>>> GetAllBatches()
        { 
            if(computerSeekhoDbContext.Batches == null)
            {
                return null;
            }
            return await computerSeekhoDbContext.Batches.ToListAsync();
        }

        public async Task<ActionResult<Batch>?> GetBatchByBatchId(int BatchId)
        {
            if(computerSeekhoDbContext.Batches == null)
            {
                return null;
            }
            var batch =await computerSeekhoDbContext.Batches.FindAsync(BatchId);
            if(batch == null)
            {
                return null;    
            }
            return batch;
        }

        public async Task<bool> Update(Batch batch)
        {

            if (batch == null)
            {
                return false;
            }

            computerSeekhoDbContext.Entry(batch).State = EntityState.Modified;

            try
            {
                await computerSeekhoDbContext.SaveChangesAsync();
                return true;
            }
            catch (DbUpdateConcurrencyException ex)
            {
                if (ex.InnerException != null)
                {
                    return false;
                }
                else
                {
                    throw ex;
                }
            }

        }
    }
}
