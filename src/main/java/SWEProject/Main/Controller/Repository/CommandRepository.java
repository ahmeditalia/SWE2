package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Command;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommandRepository extends CommandBaseRepository<Command> {

}
