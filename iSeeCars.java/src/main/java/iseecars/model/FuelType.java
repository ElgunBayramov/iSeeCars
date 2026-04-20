package iseecars.model;

public enum FuelType {
    PETROL(1),
    DIESEL(2),
    HYBRID(3),
    ELECTRIC(4),
    GAS(5);

    private final int value;
    FuelType(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
