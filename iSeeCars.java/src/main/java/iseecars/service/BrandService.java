package iseecars.service;

import iseecars.model.Brand;
import iseecars.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

//    private List<Brand> brands = new ArrayList<>();
//    private int nextId = 1;
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository){

        this.brandRepository = brandRepository;
    }

//    public Brand addBrand(Brand brand) {
//        if(brand == null || brand.getBrandName() == null || brand.getBrandName().isBlank()){
//            throw new IllegalArgumentException(("Brand cannot be empty."));
//        }
//
//        brand.setBrandId(nextId++);
//        brands.add(brand);
//        return brand;
//    }

    public Brand addBrand(Brand brand){
        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    public Brand getBrandById(int id){
        return brandRepository.findById(id).orElse(null);
    }

    public boolean removeBrandById(int id){
        if(!brandRepository.existsById(id)) return false;
        brandRepository.deleteById(id);
        return true;
    }

    public Brand updateBrand(int id, Brand updated){
        Brand existing = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        existing.setBrandName(updated.getBrandName());

        return brandRepository.save(existing);
    }




//    public Brand getBrandById(int id){
//        return brands.stream()
//                .filter(b -> b.getBrandId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//    public Brand updateBrand(int id, Brand updatedBrand){
//        Brand existingBrand = getBrandById(id);
//        if(existingBrand == null){
//            return null;
//        }
//        existingBrand.setBrandName(updatedBrand.getBrandName());
//        return existingBrand;
//    }


//    public List<Brand> getAllBrands() {
//        return brands;
//    }

//    public boolean removeBrandById(int id) {
//        Brand brand = getBrandById(id);
//        if(brand == null){
//            return false;
//        }
//        brands.remove(brand);
//        return true;
//    }
}