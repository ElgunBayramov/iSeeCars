package iseecars.model;

public class Car {
    private int carId;
    private int modelId;
    private double price;
    private String color;
    private FuelType fuelType;
    private double engine;
    private int year;


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
