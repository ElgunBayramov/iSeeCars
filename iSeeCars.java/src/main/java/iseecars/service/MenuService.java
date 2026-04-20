package iseecars.service;

import iseecars.helper.ConsoleHelper;
import iseecars.helper.InputHelper;
import iseecars.manager.BrandManager;
import iseecars.manager.CarManager;
import iseecars.manager.ModelManager;
import iseecars.model.Car;
import iseecars.model.MenuOptions;

import java.util.Arrays;

public class MenuService {

    private final ModelManager modelManager;
    private final CarManager carManager;
    private BrandManager brandManager;
    private final InputService inputService;

    public MenuService(ModelManager modelManager,
                       CarManager carManager,
                       BrandManager brandManager,
                       InputService inputService) {
        this.modelManager = modelManager;
        this.carManager = carManager;
        this.brandManager = brandManager;
        this.inputService = inputService;
    }

    public void showMenu() {
        System.out.println("============== MENU ==============");

        for (MenuOptions option : MenuOptions.values()) {
            System.out.println(option.getValue() + ". " + option);
        }
    }

    public void readMenu() {

        boolean exit = false;

        while (!exit) {

            showMenu();
            System.out.println("-----------------------------");

            int value = InputHelper.readInt(
                    "Choose one of the operations:",
                    v -> Arrays.stream(MenuOptions.values())
                            .anyMatch(option -> option.getValue() == v),
                    "Please try to select from menu"
            );

            MenuOptions choice = Arrays.stream(MenuOptions.values())
                    .filter(option -> option.getValue() == value)
                    .findFirst()
                    .orElse(null);

            switch (choice) {

                // ================= CARS =================

                case CARS_ALL -> {
                    carManager.showAllCars();
                    ConsoleHelper.pause();
                }

                case CAR_ID -> {
                    int carId = inputService.readCarFromUser("Enter a car id:");
                    carManager.printCarById(carId);
                    ConsoleHelper.pause();
                }

                case CAR_ADD -> {
                    Car car = inputService.addCarFromUser();

                    if (car == null) {
                        ConsoleHelper.pause();
                        break;
                    }

                    carManager.addCar(car);
                    System.out.println("Car added successfully!");
                    ConsoleHelper.pause();
                }

                case CAR_EDIT -> {
                    System.out.println("Car edit not implemented yet");
                    ConsoleHelper.pause();
                }

                case CAR_REMOVE -> {
                    System.out.println("Car remove not implemented yet");
                    ConsoleHelper.pause();
                }

                // ================= BRANDS =================

                case BRANDS_ALL -> {
//                    carManager.showAllCars(); // əgər brand manager varsa dəyişəcəksən
                    ConsoleHelper.pause();
                }

                case BRAND_ID -> {
                    System.out.println("Brand by id not implemented");
                    ConsoleHelper.pause();
                }

                case BRAND_ADD -> {
                    System.out.println("Brand add not implemented");
                    ConsoleHelper.pause();
                }

                case BRAND_EDIT -> {
                    System.out.println("Brand edit not implemented");
                    ConsoleHelper.pause();
                }

                case BRAND_REMOVE -> {
                    System.out.println("Brand remove not implemented");
                    ConsoleHelper.pause();
                }

                // ================= MODELS =================

                case MODELS_ALL -> {
                    modelManager.showAllModels();
                    ConsoleHelper.pause();
                }

                case MODEL_ID -> {
                    System.out.println("Model by id not implemented");
                    ConsoleHelper.pause();
                }

                case MODEL_ADD -> {
                    modelManager.addModel();
                    System.out.println("Model added successfully!");
                    ConsoleHelper.pause();
                }

                case MODEL_EDIT -> {
                    System.out.println("Model edit not implemented");
                    ConsoleHelper.pause();
                }

                case MODEL_REMOVE -> {
                    System.out.println("Model remove not implemented");
                    ConsoleHelper.pause();
                }

                // ================= OTHER =================

                case ALL -> {
                    System.out.println("Not implemented yet");
                    ConsoleHelper.pause();
                }

                case EXIT -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
            }
        }
    }
}