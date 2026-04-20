package iseecars.manager;

import iseecars.model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandManager {
    private List<Brand> brands = new ArrayList<Brand>();

    public void addBrand(Brand brand){
        brands.add(brand);
    }
    public List<Brand> getAllBrands(){
        return brands;
    }
    public void removeBrand(Brand brand){
        brands.remove(brand);
    }
}
