package iseecars.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private int modelId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Transient
    public String modelName;

    private double price;
    private String color;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    private double engine;
    private String imagePath;
    private int year;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId){
        this.carId = carId;
    }

    public int getModelId(){
        return modelId;
    }
    public void setModelId(int modelId){
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public FuelType getFuelType(){
        return fuelType;
    }

    public void setFuelType(FuelType fuelType){
        this.fuelType = fuelType;
    }

    public double getEngine(){
        return engine;
    }
    public void setEngine(double engine){
        this.engine = engine;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }


}
