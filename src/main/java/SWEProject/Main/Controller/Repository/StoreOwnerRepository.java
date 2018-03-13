package SWEProject.Main.Controller.Repository;

import org.springframework.transaction.annotation.Transactional;
import SWEProject.Main.Controller.Entities.StoreOwner;

@Transactional
public interface StoreOwnerRepository extends UserBaseRepository<StoreOwner>{

}
