package iseecars.controller;

import org.springframework.web.multipart.MultipartFile;
import iseecars.service.CarService;
import iseecars.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService){

        this.carService = carService;
    }

    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Car car = carService.getCarById(id);
        return car == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(car);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestPart("car") Car car, @RequestPart("image") MultipartFile image){
        return ResponseEntity.ok(carService.addCar(car,image));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestPart("car") Car car,@RequestPart(value="image", required = false) MultipartFile image){
        Car updatedCar = carService.updateCar(id,car,image);
        return updatedCar == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updatedCar);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        boolean deleted = carService.removeCarById(id);

        return deleted
                ? ResponseEntity.ok("Car deleted successfully")
                : ResponseEntity.notFound().build();
    }

}
