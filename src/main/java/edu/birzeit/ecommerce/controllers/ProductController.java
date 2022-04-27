package edu.birzeit.ecommerce.controllers;

import edu.birzeit.ecommerce.models.Product;
import edu.birzeit.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product>getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }
    @PostMapping("/{supplierId}")
    public Product addProduct(@PathVariable Long supplierId,@RequestBody Product product){
        return productService.addProduct(supplierId, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
