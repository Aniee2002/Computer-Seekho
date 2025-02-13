using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Service;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Controllers;

[Route("api/[controller]")]
[ApiController]
public class PaymentTypeController : ControllerBase
{
    private readonly IpaymentTypeService _paymentTypeService;
    //private readonly ILogger _logger;
    public PaymentTypeController(IpaymentTypeService paymentTypeService)
    {
        _paymentTypeService = paymentTypeService;
    }

    [HttpGet]
    public async Task<ActionResult<IEnumerable<PaymentType>>> GetAllPayments()
    {
        return await _paymentTypeService.GetPaymentTypes();
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<PaymentType>> GetPaymentType(int id)
    {
        return await _paymentTypeService.GetById(id);
    }
}
