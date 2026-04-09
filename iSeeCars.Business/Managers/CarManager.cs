using iSeeCars.Core.Entities;

namespace iSeeCars.Business.Managers
{
    public class CarManager
    {
        private readonly ModelManager modelManager;
        public CarManager(ModelManager modelManager) {
            this.modelManager = modelManager;
        }
        List<Car> cars = new List<Car>();
        private int nextId = 1;

        public void AddCar(Car car)
        {
            if (car == null)
                throw new ArgumentNullException();

            if (!modelManager.GetAllModels()
                .Any(x => x.ModelId == car.ModelId))
                throw new Exception("Model not found");

            car.CarId = nextId++;

            cars.Add(car);

        }
        #region ManualGetByid
        //public void GetCarById(int id)
        //{
        //    Car car = null;
        //    foreach (var item in cars)
        //    {
        //        if(id == item.CarId)
        //        {
        //            car = item;
        //            Console.WriteLine($"model name:{car.ModelId} price:{car.Price}, color:{car.Color}, fuel type:{car.FuelType}, engine: {car.Engine}, year:{car.Year.ToString("yyyy")}");
        //            break;
        //        }
        //    }

        //}
        #endregion

        public Car GetCarById(int id)
        {
            return cars.FirstOrDefault(c => c.CarId == id);
        }
        // Konsol üçün
        public void PrintCarById(int id, ModelManager modelManager)
        {
            var car = cars.FirstOrDefault(c => c.CarId == id);
            if (car == null)
            {
                Console.WriteLine("Car not found");
                return;
            }

            var model = modelManager.GetModelById(car.ModelId);
            string modelName = model?.ModelName ?? "Unknown";
            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.WriteLine($"Model name:{modelName}, price:{car.Price}, color:{car.Color}, fuel type:{car.FuelType}, engine: {car.Engine}, year:{car.Year:yyyy}");
        }
        public List<Car> GetAllCars()
        {
            return cars;
        }
        public void ShowAllCars(ModelManager modelManager)
        {
            if (cars.Count == 0)
            {
                Console.WriteLine("Car not found");
            }
            else
            {

                foreach (var car in cars)
                {
                    var model = modelManager.GetModelById(car.ModelId);
                    string modelName = model.ModelName;
                    Console.ForegroundColor = ConsoleColor.Magenta;
                    Console.WriteLine($"id:{car.CarId},model name:{modelName}, price:{car.Price}, color:{car.Color}, fuel type:{car.FuelType}, engine: {car.Engine}, year:{car.Year.ToString("yyyy")}");
                }

            }
        }
        public void RemoveCar(Car car)
        {
            cars.Remove(car);
        }
    }
}
