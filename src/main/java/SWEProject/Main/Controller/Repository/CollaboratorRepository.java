package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Collaborator;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollaboratorRepository extends UserBaseRepository<Collaborator> {

    @Query("select s.storeName from Store s,Collaborator c ,StoreOwner o " +
            "where s.storeOwner =:username and c.storeOwner =:username and o.username =:username")
    List<Store> findByStoreOwner(@Param("username") StoreOwner storeOwner);
}
