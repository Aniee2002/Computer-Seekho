using System.Text.Json;
using System.Text;
using Computer_Seekho_DN.DTO;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Service;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Controllers;

[Route("api/[controller]")]
[ApiController]
public class PaymentController : ControllerBase
{
    private readonly IpaymentService _paymentService;
    public PaymentController(IpaymentService paymentService)
    {
        _paymentService = paymentService;
    }
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Payment>>> GetAllPayments()
    {
        return Ok(await _paymentService.getPaymentList());
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<Payment>> GetPayment(int id)
    {
        var payment = await _paymentService.getPayment(id);
        if (payment.Amount == null)
            return NotFound($"Payment with ID {id} not found.");

        return payment;
    }

    [HttpPost]
    public async Task<ActionResult<Payment>> AddPayment([FromBody] Payment payment)
    {
        if (payment == null)
            return BadRequest("Invalid payment data.");
        var result = await _paymentService.Add(payment);
        PaymentDTO paymentDTO = (await _paymentService.getPaymentDTO(result.PaymentId));
        await _paymentService.UpdatePaymentDueAsync(payment.Student.StudentId, (int)payment.Amount);
        return CreatedAtAction(nameof(GetPayment), new { id = result.PaymentId }, result);
    }
}