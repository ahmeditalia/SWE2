package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepository  extends CrudRepository<Brand,Integer> {
    List<Brand> findByProducts(String name);
    boolean existsByName(String name);
}
