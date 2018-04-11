package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.DeleteProductCommand;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DeleteProductCommandRepository extends CommandBaseRepository<DeleteProductCommand> {
}
