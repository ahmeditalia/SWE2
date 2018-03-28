package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.StoreProduct;

import java.util.List;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer>{
    StoreProduct findByname(String name);
}
