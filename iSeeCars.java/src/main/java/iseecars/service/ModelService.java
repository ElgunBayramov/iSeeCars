package iseecars.service;

import iseecars.model.Brand;
import iseecars.model.Model;
import iseecars.repository.BrandRepository;
import iseecars.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ModelService {
//    private List<Model> models = new ArrayList<>();
//    private int nextId = 1;
//    private final BrandService brandService;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
//    private Scanner scanner = new Scanner(System.in);

public ModelService(ModelRepository modelRepository, BrandRepository brandRepository){
    this.modelRepository = modelRepository;
    this.brandRepository = brandRepository;

}

    public Model addModel(Model model) {

        Brand brand = brandRepository.findById(model.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        return modelRepository.save(model);
    }

    public Model getModelById(int id) {
        return modelRepository.findById(id).orElse(null);
    }
    public Model updateModel(int id, Model updatedModel) {

        Model existing = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Model not found"));

        Brand brand = brandRepository.findById(updatedModel.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        existing.setModelName(updatedModel.getModelName());
        existing.setBrandId(updatedModel.getBrandId());

        return modelRepository.save(existing);
    }

    public List<Model> getAllModels() {
        List<Model> models = modelRepository.findAll();

        for (Model model : models) {
            Brand brand = brandRepository.findById(model.getBrandId()).orElse(null);

            if (brand != null) {
                model.setBrandName(brand.getBrandName());
            } else {
                model.setBrandName("Unknown");
            }
        }

        return models;
    }

    public boolean removeModelById(int id) {
        if (!modelRepository.existsById(id)) return false;
        modelRepository.deleteById(id);
        return true;
    }
    // Console Version
//    public Model addModel(){
//        String mdlName;
//
//        while(true){
//            System.out.println("Enter a model name");
//            mdlName = scanner.nextLine();
//
//            if(mdlName != null && !mdlName.isBlank()){
//                break;
//            }
//            System.out.println("Model name cannot be empty");
//        }
//        Model newModel = new Model();
//        newModel.setModelId(nextId++);
//        newModel.setModelName(mdlName);
//
//        models.add(newModel);
//        return newModel;
//
//    }


    // API Version
//    public Model addModel(Model model) {
//        if (model == null || model.getModelName() == null || model.getModelName().isBlank()) {
//            throw new IllegalArgumentException("Model is null or name is empty");
//        }
//
//        Brand brand = brandService.getBrandById(model.getBrandId());
//
//        if(brand == null){
//            throw new RuntimeException("Brand not found");
//        }
//
//        model.setModelId(nextId++);
//        model.setBrandName(brand.getBrandName());
//        models.add(model);
//        return model;
//    }
//
//    public Model getModelById(int id){
//       Model model = models.stream()
//               .filter(m -> m.getModelId() == id)
//               .findFirst()
//               .orElse(null);
//
//       if (model != null){
//           Brand brand = brandService.getBrandById(model.getBrandId());
//           if(brand != null){
//               model.setBrandName(brand.getBrandName());
//           }
//           else{
//               model.setBrandName("Unknowm");
//           }
//       }
//       return model;
//    }
//
//    public Model updateModel(int id, Model updatedModel){
//        Model existingModel = getModelById(id);
//        if(existingModel == null){
//            return null;
//        }
//        existingModel.setModelName(updatedModel.getModelName());
//        return existingModel;
//    }
//
//    public List<Model> getAllModels(){
//      for(Model model : models){
//          Brand brand = brandService.getBrandById(model.getBrandId());
//
//          if(brand != null){
//              model.setBrandName(brand.getBrandName());
//          }
//          else{
//              model.setBrandName("Unknown");
//          }
//      }
//      return models;
//    }

//    public void showAllModels(){
//        if(models.isEmpty()){
//            System.out.println("Model not found");
//            return;
//        }
//
//        for(Model mdl : models){
//            System.out.println(mdl.getModelId() + ". " + mdl.getModelName());
//        }
//    }
//    public boolean removeModelById(int id){
//        Model model = getModelById(id);
//        if(model == null){
//            return false;
//        }
//        models.remove(model);
//        return true;
//    }


}
