package SWEProject.Main.Controller.Repository;




import org.springframework.transaction.annotation.Transactional;

import SWEProject.Main.Controller.Entities.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User>{

}
