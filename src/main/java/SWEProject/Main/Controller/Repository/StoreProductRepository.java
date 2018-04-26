package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer>{

    StoreProduct findByNameAndStoreAndExist(String name,Store store, String exist);
    List<StoreProduct> findByNameAndExist(String name , String exist);
    List<StoreProduct> findAllByExist(String exist);

    List<StoreProduct> findByStore_StoreNameAndExist(String storeName , String exist);
    StoreProduct findByNameAndStore_storeName(String name , String store);
    @Transactional
    @Modifying
    @Query("update StoreProduct s set s.quantity = s.quantity-:quantity where s.store = :store and s.id=:id and exist = 'exist'")
    void updateQuantity(@Param("quantity") int quantity,@Param("store") Store storeName,@Param("id") int id);
    List<StoreProduct> findByCarts_Id(Integer id);
    boolean existsByNameAndStoreAndExist(String name,Store store,String exist);
    boolean existsByNameAndCarts_Id(String name,Integer id);
}