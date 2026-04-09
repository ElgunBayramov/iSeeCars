using Microsoft.AspNetCore.Mvc;
using iSeeCars.Business.Managers;
using iSeeCars.Core.Entities;


[ApiController]
[Route("api/[controller]")]
public class ModelController : ControllerBase
{
    private readonly ModelManager modelManager;

    public ModelController(ModelManager modelManager)
    {
        this.modelManager = modelManager;
    }

    [HttpGet]
    [Route("getAllModels")]
    public IActionResult GetAll()
    {
        return Ok(modelManager.GetAllModels());
    }

    [HttpPost]
    [Route("add")]
    public IActionResult Add(Model model)
    {
        modelManager.AddModel(model);
        return Ok(model);
    }
}
