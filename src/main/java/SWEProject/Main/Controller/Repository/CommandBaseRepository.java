package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface CommandBaseRepository <T extends Command> extends CrudRepository<T, Integer> {

}