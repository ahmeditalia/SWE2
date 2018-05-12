package SWEProject.Main.Controller.Repository;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.Stat;

public interface StatRepository extends CrudRepository<Stat, Integer>{
	
}
