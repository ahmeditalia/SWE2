package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.OnlineStore;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreIdentity;

public interface OnlineStoreRepository extends CrudRepository<OnlineStore,StoreIdentity> {

    //Iterable<Store> findByStoreNameAndStoreOwner(String storeName,String StoreOwner);
}
