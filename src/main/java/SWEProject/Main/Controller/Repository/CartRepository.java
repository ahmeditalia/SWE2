package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Cart;
import org.springframework.data.repository.CrudRepository;

public interface  CartRepository extends CrudRepository<Cart,Integer> {
}
