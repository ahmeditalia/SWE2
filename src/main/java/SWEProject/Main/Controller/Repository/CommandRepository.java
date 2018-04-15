package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Command;
import org.springframework.data.repository.CrudRepository;

public interface CommandRepository extends CrudRepository<Command, Integer> {

}
