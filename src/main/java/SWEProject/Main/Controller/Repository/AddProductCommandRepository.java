package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.AddProductCommand;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AddProductCommandRepository extends CommandBaseRepository<AddProductCommand> {
}
