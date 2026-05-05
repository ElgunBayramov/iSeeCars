package iseecars.controller;

import iseecars.model.Brand;
import iseecars.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Brand brand = brandService.getBrandById(id);

        return brand == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(brand);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.addBrand(brand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody Brand brand) {

        Brand updatedBrand = brandService.updateBrand(id, brand);

        return updatedBrand == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(updatedBrand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean deleted = brandService.removeBrandById(id);

        return deleted
                ? ResponseEntity.ok("Brand deleted successfully")
                : ResponseEntity.notFound().build();
    }
}