package SWEProject.Main.Controller.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import SWEProject.Main.Controller.Entities.Store;

@NoRepositoryBean

public interface StoreBaseRepository <T extends Store> extends CrudRepository<T, String>{
	@Query("select count(*) from Store where status = 'Onhold' ")
	int countOnHold();
	
	List<Store> findByStatus(String status);
	

}
