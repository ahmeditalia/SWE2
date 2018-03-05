package SWEProject.Main.Controller.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import SWEProject.Main.Controller.Entities.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, String>{

    T findOneByUsernameAndPassword(String username, String password);
    boolean existsByUsernameAndPassword(String username, String password);
}
