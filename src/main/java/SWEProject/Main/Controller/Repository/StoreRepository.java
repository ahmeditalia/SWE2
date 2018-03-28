package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Store;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface StoreRepository  extends StoreBaseRepository<Store> {
    Store findOneByStoreName(String StoreName);
}
