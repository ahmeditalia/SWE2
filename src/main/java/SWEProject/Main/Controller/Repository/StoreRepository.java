package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Command;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StoreRepository  extends StoreBaseRepository<Store> {

    Store findOneByStoreName(String StoreName);

    @Query("select s.commands from Store s where s.storeOwner =:username")
    List<Command> findByStoreOwner(@Param("username") StoreOwner storeOwner);
}
