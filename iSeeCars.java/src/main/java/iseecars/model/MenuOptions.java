package iseecars.model;

public enum MenuOptions {
    CARS_ALL(1),
    CAR_ID(2),
    CAR_ADD(3),
    CAR_EDIT(4),
    CAR_REMOVE(5),

    BRANDS_ALL(6),
    BRAND_ID(7),
    BRAND_ADD(8),
    BRAND_EDIT(9),
    BRAND_REMOVE(10),

    MODELS_ALL(11),
    MODEL_ID(12),
    MODEL_ADD(13),
    MODEL_EDIT(14),
    MODEL_REMOVE(15),

    ALL(16),
    EXIT(17);

    private final int value;

    MenuOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}