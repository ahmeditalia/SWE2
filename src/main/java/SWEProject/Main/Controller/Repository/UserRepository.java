package SWEProject.Main.Controller.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.User;

public interface UserRepository extends CrudRepository<User, String>{


    List<User> findByUsernameAndPassword(String username, String password);

    boolean existsByUsernameAndPassword(String username, String password);
}
