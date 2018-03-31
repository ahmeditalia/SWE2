package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.SystemProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.StoreProduct;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer>{
    StoreProduct findByNameAndStore(String name,String store);
    List<StoreProduct> findByName(String name);
    @Query("update StoreProduct s set s.quantity = s.quantity-:quantity where s.store = :store and s.id=:id")
    void updateQuantity(@Param("quantity") int quantity,@Param  ("store") String storeName,@Param("id") int id);

}
