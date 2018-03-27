package SWEProject.Main.Controller.Repository;


import org.springframework.transaction.annotation.Transactional;
import SWEProject.Main.Controller.Entities.OnlineStore;

@Transactional
public interface OnlineStoreRepository extends StoreBaseRepository<OnlineStore>{

}
