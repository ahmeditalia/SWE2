package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.SystemProduct;

import java.util.List;

public interface SystemProductRepository extends CrudRepository<SystemProduct, Integer>{
    SystemProduct findOneByName(String name);
    List<SystemProduct> findByBrand(String name);
    boolean existsByName(String name);

}
