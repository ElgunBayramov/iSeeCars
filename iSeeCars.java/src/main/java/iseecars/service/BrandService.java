package iseecars.service;

import iseecars.model.Brand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
