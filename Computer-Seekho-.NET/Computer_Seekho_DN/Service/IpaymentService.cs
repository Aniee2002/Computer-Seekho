using Computer_Seekho_DN.DTO;
using Computer_Seekho_DN.Models;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Service;

public interface IpaymentService
{
    Task<ActionResult<Payment>> getPayment(int id);
    Task<ActionResult<IEnumerable<Payment>>> getPaymentList();
    Task<ActionResult<Payment>> Add(Payment payment);
    Task<ActionResult<PaymentDTO>> getPaymentDTO(int id);
    Task UpdatePaymentDueAsync(int studentId, int amount);
}
