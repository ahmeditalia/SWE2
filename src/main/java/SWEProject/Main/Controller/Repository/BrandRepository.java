package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepository  extends CrudRepository<Brand,Integer> {
    boolean existsByName(String name);
    Brand findBrandByName(String name);
    Brand findOneByName(String name);
}
