package iseecars.controller;
import iseecars.service.ModelService;
import iseecars.model.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/model")
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/getAllModels")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(modelService.getAllModels());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Model model) {
       return ResponseEntity.ok(modelService.addModel(model));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Model model = modelService.getModelById(id);
        return model == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Model model){
        Model updatedModel = modelService.updateModel(id,model);

        return updatedModel == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updatedModel);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleted = modelService.removeModelById(id);

        return deleted
                ? ResponseEntity.ok("Model deleted succesfully")
                : ResponseEntity.notFound().build();
    }
}