package iseecars.manager;

import iseecars.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModelManager {
    private List<Model> models = new ArrayList<Model>();
    private int nextId = 1;
    private Scanner scanner = new Scanner(System.in);



    // Console Version
    public Model addModel(){
        String mdlName;

        while(true){
            System.out.println("Enter a model name");
            mdlName = scanner.nextLine();

            if(mdlName != null && !mdlName.isBlank()){
                break;
            }
            System.out.println("Model name cannot be empty");
        }
        Model newModel = new Model();
        newModel.setModelId(nextId++);
        newModel.setModelName(mdlName);

        models.add(newModel);
        return newModel;

    }


    // API Version
    public Model addModel(Model model) {
        if (model == null || model.getModelName() == null || model.getModelName().isBlank()) {
            throw new IllegalArgumentException("Model is null or name is empty");
        }

        model.setModelId(nextId++);
        models.add(model);
        return model;
    }

    public Model getModelById(int id){
        return models.stream()
                .filter(m -> m.getModelId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Model> getAllModels(){
        return models;
    }

    public void showAllModels(){
        if(models.isEmpty()){
            System.out.println("Model not found");
            return;
        }

        for(Model mdl : models){
            System.out.println(mdl.getModelId() + ". " + mdl.getModelName());
        }
    }
    public void removeModel(Model model){
        models.remove(model);
    }


}
