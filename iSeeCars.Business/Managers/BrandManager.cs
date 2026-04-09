using iSeeCars.Core.Entities;

namespace iSeeCars.Business.Managers
{
    public class BrandManager
    {
        List<Brand> brands = new List<Brand>();

        public void AddBrand(Brand brand)
        {
            brands.Add(brand);
        }

        public List<Brand> GetAllBrands()
        {
            return brands;
        }
        public void RemoveBrand(Brand brand)
        {
            brands.Remove(brand);
        }
    }
}
