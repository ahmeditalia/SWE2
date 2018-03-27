package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.SystemProduct;

import java.util.List;

public interface SystemProductRepository extends CrudRepository<SystemProduct, Integer>{
    List<SystemProduct> findByBrand(String name);
}
