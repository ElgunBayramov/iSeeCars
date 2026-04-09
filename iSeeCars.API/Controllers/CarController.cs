using iSeeCars.Business.Managers;
using iSeeCars.Core.Entities;
using Microsoft.AspNetCore.Mvc;

[ApiController]
[Route("api/[controller]")]
public class CarController : ControllerBase
{
    private readonly CarManager carManager;

    public CarController(CarManager carManager)
    {
        this.carManager = carManager;
    }

    [HttpGet("getAllCars")]
    public IActionResult GetAll() => Ok(carManager.GetAllCars());

    [HttpGet("{id}")]
    public IActionResult GetById(int id)
    {
        var car = carManager.GetCarById(id);
        return car == null ? NotFound() : Ok(car);
    }

    [HttpPost("add")]
    public IActionResult Add([FromBody] Car car)
    {
        carManager.AddCar(car);
        return Ok(car);
    }
}