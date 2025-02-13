using Computer_Seekho_DN.DTO;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Repository;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Computer_Seekho_DN.Service;

public class PaymentService : IpaymentService
{
    private readonly ComputerSeekhoDbContext _dbContext;

    public PaymentService(ComputerSeekhoDbContext dbContext)
    {
        _dbContext = dbContext;
    }
    public async Task<ActionResult<Payment>> Add(Payment payment)
    {
        _dbContext.Payments.Add(payment);
        await _dbContext.SaveChangesAsync();
        return payment;
    }

    public async Task<ActionResult<Payment>> getPayment(int id)
    {
        return await _dbContext.Payments.FindAsync(id);
    }

    public async Task<ActionResult<IEnumerable<Payment>>> getPaymentList()
    {
        return await _dbContext.Payments.ToListAsync();
    }

    public async Task UpdatePaymentDueAsync(int studentId, int amount)
    {
        var student = await _dbContext.Students.FirstOrDefaultAsync(s => s.StudentId == studentId);
        if (student != null)
        {
            student.PaymentDue -= amount;
            await _dbContext.SaveChangesAsync();
        }
    }

    public async Task<ActionResult<PaymentDTO?>> getPaymentDTO(int paymentId)
    {
        return await (from p in _dbContext.Payments
                      join s in _dbContext.Students on p.StudentId equals s.StudentId
                      join pt in _dbContext.PaymentTypes on p.PaymentTypeId equals pt.PaymentTypeId
                      where p.PaymentId == paymentId
                      select new PaymentDTO(
                          s.StudentName,
                          s.StudentEmail,
                          (int)p.Amount,
                          (DateOnly)p.PaymentDate,
                          pt.PaymentTypeDesc
                      )).FirstOrDefaultAsync();
    }
}
