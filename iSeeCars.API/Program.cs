using FluentValidation;
using iSeeCars.Business.Managers;
using iSeeCars.Business.Validators;
using iSeeCars.Core.Entities;
var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddSingleton<CarManager>();
builder.Services.AddSingleton<ModelManager>();
builder.Services.AddSingleton<BrandManager>();
builder.Services.AddSingleton<IValidator<Car>, CarValidator>();

var app = builder.Build();

app.UseSwagger();
app.UseSwaggerUI(c =>
{
    c.SwaggerEndpoint("/swagger/v1/swagger.json", "iSeeCars API V1");
    c.RoutePrefix = "swagger";
});

app.UseAuthorization();
app.MapControllers();
app.Run("http://0.0.0.0:8080");