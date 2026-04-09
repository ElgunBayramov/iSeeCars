using iSeeCars.Business.Managers;
using iSeeCars.Core.Entities;
using Microsoft.AspNetCore.Mvc;


[ApiController]
[Route("api/[controller]")]
public class BrandController : ControllerBase
{
    private readonly BrandManager brandManager;

    public BrandController(BrandManager brandManager)
    {
        this.brandManager = brandManager;
    }

    [HttpGet]
    public IActionResult GetAll()
    {
        return Ok(brandManager.GetAllBrands());
    }

    [HttpPost]
    [Route("add")]
    public IActionResult Add(Brand brand)
    {
        brandManager.AddBrand(brand);
        return Ok(brand);
    }
}