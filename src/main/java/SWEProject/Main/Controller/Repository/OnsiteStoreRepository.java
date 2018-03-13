package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.OnsiteStore;
import SWEProject.Main.Controller.Entities.StoreIdentity;

public interface OnsiteStoreRepository extends CrudRepository<OnsiteStore, StoreIdentity>{

}
