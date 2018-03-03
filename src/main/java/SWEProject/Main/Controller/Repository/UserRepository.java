package SWEProject.Main.Controller.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import SWEProject.Main.Controller.Entities.User;

public interface UserRepository extends CrudRepository<User, String>{


    @Query("select u from User u where u.username=:username and u.Password=:Password")
    User findByID(@Param("username") String usernme, @Param("Password") String pass);

    @Query("select a from User a where a.username=:username and a.Password=:Password")
    boolean existsByID(@Param("username") String usernme, @Param("Password") String pass);
}
