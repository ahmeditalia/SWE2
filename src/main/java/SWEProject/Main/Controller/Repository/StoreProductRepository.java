package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.SystemProduct;
import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.StoreProduct;

import java.util.List;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer>{
    StoreProduct findBynameAndStoreName(String name,String storeName);
    List<StoreProduct> findByName(String name);


}
