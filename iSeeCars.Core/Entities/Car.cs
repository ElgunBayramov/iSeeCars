namespace iSeeCars.Core.Entities
{
    public class Car
    {
        public int CarId { get; set; }
        public int ModelId { get; set; }
        public double Price { get; set; }
        public string Color { get; set; }
        public FuelType FuelType { get; set; }
        public double Engine { get; set; }
        public int Year { get; set; }
    }
}