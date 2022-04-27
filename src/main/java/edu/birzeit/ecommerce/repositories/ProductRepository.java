package edu.birzeit.ecommerce.repositories;

import edu.birzeit.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
