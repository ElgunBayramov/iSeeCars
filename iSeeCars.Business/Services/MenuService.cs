using iSeeCars.Business.Helpers;
using iSeeCars.Business.Managers;
using iSeeCars.Core.Entities;

namespace iSeeCars.API.Services
{
    internal class MenuService
    {
        private ModelManager modelManager;
        private CarManager carManager;
        private InputService inputService;

        public MenuService(ModelManager modelManager, CarManager carManager,InputService inputService)
        {
            this.modelManager = modelManager;
            this.carManager = carManager;
            this.inputService = inputService;
        }

        public void ShowMenu()
        {
            Console.ForegroundColor = ConsoleColor.Yellow;
            Console.WriteLine("==============Menu=================");
            InputHelper.ShowEnum<MenuOptions>();
        }

        public void ReadMenu()
        {
            bool exit = false;

            while (!exit)
            {
                ShowMenu();
                Console.WriteLine("-----------------------------");

                int value = InputHelper.ReadInt("Choose one of the operations: ", v => Enum.IsDefined(typeof(MenuOptions), v),
            "Please try to choose from the list...");
                ConsoleHelper.ClearLastInput();
                MenuOptions choice = (MenuOptions)value;
                switch (choice)
                {
                    case MenuOptions.CarsAll:
                        carManager.ShowAllCars(modelManager);
                        ConsoleHelper.Pause();
                        break;
                    case MenuOptions.CarId:
                        int carId = inputService.ReadCarFromUser("Enter a car id:");
                        carManager.PrintCarById(carId, modelManager);
                        ConsoleHelper.Pause();
                        break;
                    case MenuOptions.CarAdd:
                        Car car = inputService.AddCarFromUser();
                        if (car == null)
                        {
                            ConsoleHelper.Pause();
                            break;
                        }

                        carManager.AddCar(car);
                        Console.WriteLine("Car added successfully!");
                        ConsoleHelper.Pause();
                        break;

                    case MenuOptions.CarEdit:
                        Console.WriteLine("4");
                        break;
                    case MenuOptions.CarRemove:
                        Console.WriteLine("5");
                        break;
                    case MenuOptions.BrandsAll:
                        Console.WriteLine("6");
                        break;
                    case MenuOptions.BrandId:
                        Console.WriteLine("7");
                        break;
                    case MenuOptions.BrandAdd:
                        Console.WriteLine("8");
                        break;
                    case MenuOptions.BrandEdit:
                        Console.WriteLine("9");
                        break;
                    case MenuOptions.BrandRemove:
                        Console.WriteLine("10");
                        break;
                    case MenuOptions.ModelsAll:
                        modelManager.ShowAllModels();
                        ConsoleHelper.Pause();
                        break;
                    case MenuOptions.ModelId:
                        Console.WriteLine("12");
                        break;
                    case MenuOptions.ModelAdd:
                        modelManager.AddModel();
                        Console.WriteLine("Model added successfully!");
                        ConsoleHelper.Pause();
                        break;
                    case MenuOptions.ModelEdit:
                        Console.WriteLine("14");
                        break;
                    case MenuOptions.ModelRemove:
                        Console.WriteLine("15");
                        break;
                    case MenuOptions.All:
                        Console.WriteLine("16");
                        break;
                    case MenuOptions.Exit:
                        Console.WriteLine("17");
                        exit = true;
                        break;

                }

            }

        }
    }
}
