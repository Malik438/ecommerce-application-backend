package edu.birzeit.ecommerce.repositories;

import edu.birzeit.ecommerce.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
