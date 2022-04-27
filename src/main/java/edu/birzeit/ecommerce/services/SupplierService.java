package edu.birzeit.ecommerce.services;

import edu.birzeit.ecommerce.models.Product;
import edu.birzeit.ecommerce.models.Supplier;
import edu.birzeit.ecommerce.models.Workhouse;
import edu.birzeit.ecommerce.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private final SupplierRepository supplierRepository;
    private final WorkhouseService workhouseService;

    public SupplierService(SupplierRepository supplierRepository, WorkhouseService workhouseService) {
        this.supplierRepository = supplierRepository;
        this.workhouseService = workhouseService;
    }

    /**
     *
     * @return
     */
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Supplier getSupplier(Long id){
        return supplierRepository.findById(id).orElseThrow(null);
    }

    /**
     *
     * @param id
     * @param supplier
     * @return
     */

    public Supplier updateSupplier(Long id ,Supplier supplier){
        Supplier existingSupplier=getSupplier(id);
        existingSupplier.setPhone(supplier.getPhone());
        existingSupplier.setName(supplier.getName());
        return supplierRepository.save(existingSupplier);
    }

    /**
     *
     * @param workhouseId
     * @param supplier
     * @return
     */
    public Supplier addSupplier(Long workhouseId,Supplier supplier){
        Workhouse workhouse =workhouseService.getWorkhouse(workhouseId);
        supplier.setWorkhouse(workhouse);
        return supplierRepository.save(supplier);
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Product>getSupplierProducts(Long id){
        Supplier supplier=getSupplier(id);
        return supplier.getProducts();
    }

    /**
     *
     * @param id
     */
    public void deleteSupplier(Long id){
        supplierRepository.deleteById(id);
    }
}
