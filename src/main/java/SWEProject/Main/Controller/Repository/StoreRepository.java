package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.StoreIdentity;

public interface StoreRepository extends CrudRepository<Store,StoreIdentity> {

    Iterable<Store> findAllByStoreIdentity(StoreIdentity storeIdentity);
}
