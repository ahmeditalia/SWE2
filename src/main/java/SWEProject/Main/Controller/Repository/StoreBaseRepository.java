package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import SWEProject.Main.Controller.Entities.Store;

@NoRepositoryBean

public interface StoreBaseRepository <T extends Store> extends CrudRepository<T, String>{

}
