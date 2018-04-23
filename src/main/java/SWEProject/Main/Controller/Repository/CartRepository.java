package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Cart;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.StoreProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  CartRepository extends CrudRepository<Cart,Integer> {
	Cart findOneByUser_username(String username);
	/*
	@Query("select c.storeProducts from cart c where c.id =:id")
	List<StoreProduct> findByCart(@Param("id") Cart cart);
	*/
}
