package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.Product;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}
