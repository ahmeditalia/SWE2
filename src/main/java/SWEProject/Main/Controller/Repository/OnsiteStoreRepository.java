package SWEProject.Main.Controller.Repository;

import org.springframework.transaction.annotation.Transactional;
import SWEProject.Main.Controller.Entities.OnsiteStore;

@Transactional
public interface OnsiteStoreRepository extends StoreBaseRepository<OnsiteStore>{

}
