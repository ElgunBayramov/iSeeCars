using FluentValidation;
using FluentValidation.Results;
using iSeeCars.Business.Helpers;
using iSeeCars.Business.Managers;
using iSeeCars.Business.Validators;
using iSeeCars.Core.Entities;

namespace iSeeCars.API.Services
{
    internal class InputService
    {
        private readonly ModelManager modelManager;
        private readonly CarManager carManager;
        private readonly IValidator<Car> carValidator;

        public InputService(ModelManager modelManager,CarManager carManager,IValidator<Car> carValidator)
        {
            this.modelManager = modelManager;
            this.carManager = carManager;
            this.carValidator = carValidator;
        }

        public Car? AddCarFromUser()
        {
            while (true)
            {
                Car car = new Car();

            model:
                Console.WriteLine("Please choose a model from the list below:");

                var models = modelManager.GetAllModels();

                if (models.Count == 0)
                {
                    Console.WriteLine("Models not found. Do you wanna add a new model? (Y/N)");

                    var click = Console.ReadKey(true);

                    if (click.Key == ConsoleKey.Y)
                    {
                        var newModel = modelManager.AddModel();
                        car.ModelId = newModel.ModelId;
                    }
                    else if (click.Key == ConsoleKey.N)
                    {
                        Console.WriteLine("Operation cancelled");
                        return null;
                    }
                    else
                    {
                        Console.WriteLine("Please press Y or N");
                        goto model;
                    }
                }
                else
                {
                    modelManager.ShowAllModels();

                    int modelId = InputHelper.ReadInt(
                        "Enter a model ID",
                        mdlId => models.Any(m => m.ModelId == mdlId),
                        "Invalid model Id");

                    car.ModelId = modelId;
                }

                car.Price = InputHelper.ReadDouble(
                    "Enter price:",
                    v => v > 0,
                    "Invalid price");

                car.Color = InputHelper.ReadString(
                    "Enter color:",
                    v => !string.IsNullOrWhiteSpace(v),
                    "Invalid color");

                InputHelper.ShowEnum<FuelType>();

                int fuel = InputHelper.ReadInt(
                    "Select fuel:",
                    v => Enum.IsDefined(typeof(FuelType), v),
                    "Invalid fuel");

                car.FuelType = (FuelType)fuel;

                car.Engine = InputHelper.ReadDouble(
                    "Enter engine:",
                    v => v > 0,
                    "Invalid engine");

                int year = InputHelper.ReadInt(
                    "Enter year:",
                    v => v >= 1900 && v <= DateTime.Now.Year,
                    "Invalid year");

                car.Year = year;

                ValidationResult result = carValidator.Validate(car);

                if (result.IsValid)
                    return car;

                Console.ForegroundColor = ConsoleColor.Red;

                Console.WriteLine("Validation errors:");

                foreach (var error in result.Errors)
                    Console.WriteLine(error.ErrorMessage);

                Console.ResetColor();

                Console.WriteLine("Please try again...\n");
            }
        }
        public int ReadCarFromUser(string message)
        {

            return InputHelper.ReadInt(message, id => carManager.GetAllCars().Any(x => x.CarId == id),
                "Car not found");
            
        }
    }
}
