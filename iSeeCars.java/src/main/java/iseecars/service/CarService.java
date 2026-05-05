package iseecars.service;
import iseecars.model.Car;
import iseecars.model.Model;
import iseecars.repository.CarRepository;
import iseecars.repository.ModelRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {
//private List<Car> cars = new ArrayList<Car>();
//private int nextId = 1;
    private final CarRepository carRepository;
    private final ModelRepository modelRepository;

    public CarService(CarRepository carRepository, ModelRepository modelRepository){
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;

    }

    public Car addCar(Car car, MultipartFile image) {

        modelRepository.findById(car.getModelId())
                .orElseThrow(() -> new RuntimeException("Model not found"));

        if(image != null && !image.isEmpty()){
            String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
            String uploadDir = "uploads/";
            File file = new File(uploadDir + fileName);

            try{
                image.transferTo(file);
            }
            catch(IOException e){
                throw new RuntimeException("Image upload failed");
            }

            car.setImagePath("/uploads/" + fileName);
        }

        return carRepository.save(car);
    }

    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }
    public Car updateCar(int id, Car updatedCar, MultipartFile image) {

        Car existing = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        modelRepository.findById(updatedCar.getModelId())
                .orElseThrow(() -> new RuntimeException("Model not found"));

        existing.setModelId(updatedCar.getModelId());
        existing.setPrice(updatedCar.getPrice());
        existing.setColor(updatedCar.getColor());
        existing.setFuelType(updatedCar.getFuelType());
        existing.setEngine(updatedCar.getEngine());
        existing.setYear(updatedCar.getYear());

        if(image != null && !image.isEmpty()){
            String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
            String uploadDir = "uploads/";
            File file = new File(uploadDir + fileName);

            try{
                image.transferTo(file);
            }
            catch(IOException e){
               throw new RuntimeException("Image upload failed");
            }

            existing.setImagePath("/uploads/" + fileName);
        }

        return carRepository.save(existing);
    }

    public List<Car> getAllCars() {
        List<Car> cars = carRepository.findAll();

        for (Car car : cars) {
            Model model = modelRepository.findById(car.getModelId()).orElse(null);

            if (model != null) {
                car.setModelName(model.getModelName());
            } else {
                car.setModelName("Unknown");
            }
        }

        return cars;
    }

    public boolean removeCarById(int id) {
        if (!carRepository.existsById(id)) return false;
        carRepository.deleteById(id);
        return true;
    }
//    public Car addCar(Car car){
//        if(car == null){
//            throw new IllegalArgumentException("Car cannot be null");
//        }
//
//      Model model = modelService.getModelById(car.getModelId());
//
//        if(model == null){
//            throw new RuntimeException("Model not found");
//        }
//
//        car.setCarId(nextId++);
//        car.setModelName(model.getModelName());
//        cars.add(car);
//        return car;
//    }
//
//    public Car getCarById(int id) {
//        Car car = cars.stream()
//                .filter(c -> c.getCarId() == id)
//                .findFirst()
//                .orElse(null);
//
//        if (car != null) {
//            Model model = modelService.getModelById(car.getModelId());
//
//            if (model != null) {
//                car.setModelName(model.getModelName());
//            } else {
//                car.setModelName("Unknown");
//            }
//        }
//
//        return car;
//    }
//    public Car updateCar(int id, Car updatedCar){
//        Car existingCar = getCarById(id);
//
//        if(existingCar == null){
//            return null;
//        }
//
//        boolean modelExists = modelService.getAllModels()
//                .stream()
//                .anyMatch(x -> x.getModelId() == updatedCar.getModelId());
//
//        if(!modelExists){
//            throw new RuntimeException("Model not found");
//        }
//
//        existingCar.setModelId(updatedCar.getModelId());
//        existingCar.setPrice(updatedCar.getPrice());
//        existingCar.setColor(updatedCar.getColor());
//        existingCar.setFuelType(updatedCar.getFuelType());
//        existingCar.setEngine(updatedCar.getEngine());
//        existingCar.setYear(updatedCar.getYear());
//
//        Model model = modelService.getModelById(updatedCar.getModelId());
//        existingCar.setModelName(model != null ? model.getModelName() : "Unknown");
//
//        return existingCar;
//    }



//    public void printCarById(int id){
//        Car car = getCarById(id);
//
//        if(car == null){
//            out.println("Car not found");
//            return;
//        }
//
//        var model = modelService.getModelById(car.getModelId());
//        String modelName = (model != null) ? model.getModelName() : "Unknown";
//
//        out.println(
//                "Model name: " + modelName +
//                        ", price: " + car.getPrice() +
//                        ", color: " + car.getColor() +
//                        ", fuel type: " + car.getFuelType() +
//                        ", engine: " + car.getEngine() +
//                        ", year: " + car.getYear()
//        );
//    }

//    public List<Car> getAllCars() {
//
//        for (Car car : cars) {
//            Model model = modelService.getModelById(car.getModelId());
//
//            if (model != null) {
//                car.setModelName(model.getModelName());
//            } else {
//                car.setModelName("Unknown");
//            }
//        }
//
//        return cars;
//    }

//    public void showAllCars(){
//        if(cars.isEmpty()){
//            out.println("Car not found");
//            return;
//        }
//
//
//    for(Car car : cars){
//        var model = modelService.getModelById(car.getModelId());
//        String modelName = model != null ? model.getModelName() : "Unknown";
//
//        out.println(
//                "id: " + car.getCarId() +
//                        ", model name: " + modelName +
//                        ", price: " + car.getPrice() +
//                        ", color: " + car.getColor() +
//                        ", fuel type: " + car.getFuelType() +
//                        ", engine: " + car.getEngine() +
//                        ", year: " + car.getYear()
//        );
//    }
//    }
//    public boolean removeCarById(int id){
//        Car car = getCarById(id);
//        if(car == null){
//            return false;
//        }
//        cars.remove(car);
//        return true;
//    }
}
