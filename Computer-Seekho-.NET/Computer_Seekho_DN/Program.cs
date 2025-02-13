using Microsoft.EntityFrameworkCore;
using Computer_Seekho_DN.Models;
using Computer_Seekho_DN.Service;
using Computer_Seekho_DN.Repository;
using Microsoft.AspNetCore.Cors.Infrastructure;
using Computer_Seekho_DN.Exception;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container
builder.Services.AddControllers();

// Configure MySQL Database Connection
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<ComputerSeekhoDbContext>(options =>
    options.UseMySql(connectionString, ServerVersion.AutoDetect(connectionString)));

// Register your service dependencies
builder.Services.AddScoped<IstaffService, StaffService>();
builder.Services.AddScoped<IpaymentService, PaymentService>();
builder.Services.AddScoped<IpaymentTypeService, PaymentTypeService>();
builder.Services.AddScoped<IAuthService, AuthService>();
builder.Services.AddScoped<INewsService, NewsService>();



// Enable Swagger for API documentation (optional)
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddExceptionHandler<AppExceptionHandler>();

var app = builder.Build();

// Enable middleware for error handling during development
if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage();
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseExceptionHandler(_ => { });

app.UseHttpsRedirection();
app.UseAuthorization();
app.MapControllers();
app.Run();