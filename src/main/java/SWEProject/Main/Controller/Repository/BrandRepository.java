package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.SystemProduct;
import com.sun.tools.javac.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository  extends CrudRepository<Brand,Integer> {
    List<Brand> findByProduct(String name);

}
