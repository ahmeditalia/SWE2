package SWEProject.Main.Controller.Repository;

import com.sun.tools.javac.util.List;
import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.SystemProduct;

public interface SystemProductRepository extends CrudRepository<SystemProduct, Integer>{
    List<SystemProduct> findByBrand(String name);
}
