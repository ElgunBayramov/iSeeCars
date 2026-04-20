package iseecars.manager;
import static java.lang.System.out;
import iseecars.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
private List<Car> cars = new ArrayList<Car>();
private int nextId = 1;
    private ModelManager modelManager;

    public CarManager(ModelManager modelManager){

        this.modelManager = modelManager;
    }
    public void addCar(Car car){
        if(car == null){
            throw new IllegalArgumentException("Car cannot be null");
        }

        boolean modelExists = modelManager.getAllModels()
                .stream()
                .anyMatch(x -> x.getModelId() == car.getModelId());

        if(!modelExists){
            throw new RuntimeException("Model not found");
        }

        car.setCarId(nextId++);
        cars.add(car);
    }

    public Car getCarById(int id){
        return cars.stream()
                .filter(c -> c.getCarId() == id)
                .findFirst()
                .orElse(null);
    }

    public void printCarById(int id){
        Car car = getCarById(id);

        if(car == null){
            out.println("Car not found");
            return;
        }

        var model = modelManager.getModelById(car.getModelId());
        String modelName = (model != null) ? model.getModelName() : "Unknown";

        out.println(
                "Model name: " + modelName +
                        ", price: " + car.getPrice() +
                        ", color: " + car.getColor() +
                        ", fuel type: " + car.getFuelType() +
                        ", engine: " + car.getEngine() +
                        ", year: " + car.getYear()
        );
    }

    public List<Car> getAllCars(){
        return cars;
    }

    public void showAllCars(){
        if(cars.isEmpty()){
            out.println("Car not found");
            return;
        }


    for(Car car : cars){
        var model = modelManager.getModelById(car.getModelId());
        String modelName = model != null ? model.getModelName() : "Unknown";

        out.println(
                "id: " + car.getCarId() +
                        ", model name: " + modelName +
                        ", price: " + car.getPrice() +
                        ", color: " + car.getColor() +
                        ", fuel type: " + car.getFuelType() +
                        ", engine: " + car.getEngine() +
                        ", year: " + car.getYear()
        );
    }
    }
    public void removeCar(Car car){
        cars.remove(car);
    }
}
