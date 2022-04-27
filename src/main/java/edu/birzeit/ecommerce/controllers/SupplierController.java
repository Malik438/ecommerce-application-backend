package edu.birzeit.ecommerce.controllers;

import edu.birzeit.ecommerce.models.Product;
import edu.birzeit.ecommerce.models.Supplier;
import edu.birzeit.ecommerce.services.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    @GetMapping
    public List<Supplier>getSuppliers(){
        return supplierService.getSuppliers();
    }
    @GetMapping("/{id}")
    public Supplier getSupplier(@PathVariable Long id){
        return supplierService.getSupplier(id);
    }
    @GetMapping("/products/{id}")
    public List<Product>getSupplierProducts(@PathVariable Long id){
        return supplierService.getSupplierProducts(id);
    }
    @PostMapping("/{workhouseId}")
    public Supplier addSupplier(@PathVariable Long workhouseId,@RequestBody Supplier supplier){
        return supplierService.addSupplier(workhouseId,supplier);
    }
    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id,@RequestBody Supplier supplier){
        return supplierService.updateSupplier(id, supplier);
    }
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable  Long id){
        supplierService.deleteSupplier(id);
    }
}
