using Computer_Seekho_DN.Models;
using Microsoft.AspNetCore.Mvc;

namespace Computer_Seekho_DN.Service;

public interface IpaymentTypeService
{
    Task<ActionResult<IEnumerable<PaymentType>>> GetPaymentTypes();
    Task<PaymentType> Add(PaymentType paymentType);
    Task<ActionResult<PaymentType>> GetById(int id);
}