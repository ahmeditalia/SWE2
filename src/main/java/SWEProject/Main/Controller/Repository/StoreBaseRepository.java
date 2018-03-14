package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreIdentity;

@NoRepositoryBean

public interface StoreBaseRepository <T extends Store> extends CrudRepository<T, StoreIdentity>{

}
