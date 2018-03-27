package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.SystemProduct;

public interface SystemProductRepository extends CrudRepository<SystemProduct, Integer>{

<<<<<<< HEAD
    List<SystemProduct> findByBrand(String name);
    boolean existsByName(String name);

=======
>>>>>>> parent of 4258e5f... fix add product
}
