package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Command;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface CommandRepository extends CrudRepository<Command, Integer> {
	void deleteByProduct_Id(Integer id);
}
