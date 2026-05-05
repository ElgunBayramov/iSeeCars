package iseecars.service;
import static java.lang.System.out;

import iseecars.helper.InputHelper;
import iseecars.manager.CarManager;
import iseecars.manager.ModelManager;
import iseecars.model.Car;
import iseecars.model.FuelType;
import iseecars.model.Model;

import java.util.List;

public class InputService {
    private final ModelManager modelManager;
    private final CarManager carManager;

    public InputService(ModelManager modelManager, CarManager carManager){

        this.modelManager = modelManager;
        this.carManager = carManager;
    }
    public Car addCarFromUser(){
        Car car = new Car();
        List<Model> models = modelManager.getAllModels();

        if(models.isEmpty()){
            out.println("Models not found. Add new model first.");
            return null;
        }

        modelManager.showAllModels();

        int modelId = InputHelper.readInt(
            "Enter model Id:",
            id -> models.stream().anyMatch(m -> m.getModelId() == id),
            "Invalid model id"
        );
        car.setModelId(modelId);
        car.setPrice(InputHelper.readDouble(
                "Enter price:",
                v -> v > 0,
                "Invalid price"
        ));
        car.setColor(InputHelper.readString(
                "Enter color:",
                v -> !v.isBlank(),
                "Invalid color"
        ));
        for (FuelType fuelType : FuelType.values()) {
            System.out.println(fuelType.getValue() + ". " + fuelType);
        }

        int fuel = InputHelper.readInt(
                "Select fuel type from the list below:",
                v -> v >= 1 && v <= FuelType.values().length,
                "Invalid fuel type"
        );

        car.setFuelType(FuelType.values()[fuel - 1]);

        car.setEngine(InputHelper.readDouble(
                "Enter engine:",
                v -> v > 0,
                "Invalid engine"
        ));

        car.setYear(InputHelper.readInt(
                "Enter year:",
                v -> v >= 1900 && v <= 2026,
                "Invalid year"
        ));

        return car;

    }

    public int readCarFromUser(String message){
        return InputHelper.readInt(
                message,
                id -> carManager.getAllCars().stream().anyMatch(c -> c.getCarId() == id),
                "Car not found"
        );
    }
}
