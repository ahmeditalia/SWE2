package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.DeletedStoreProduct;
import SWEProject.Main.Controller.Entities.StoreProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeletedStoreProductRepository extends CrudRepository<DeletedStoreProduct,Integer> {

    @Query("select d.product from DeletedStoreProduct d where d.deleteProduct =:deleteProduct")
    StoreProduct findProductByDeleteProduct(@Param("deleteProduct") int deleteProduct);
}
