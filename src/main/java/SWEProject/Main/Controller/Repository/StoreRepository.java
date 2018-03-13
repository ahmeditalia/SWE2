package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.StoreIdentity;
import SWEProject.Main.Controller.Entities.Store;

import SWEProject.Main.Controller.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public interface StoreRepository  extends CrudRepository<Store,StoreIdentity> {

}
