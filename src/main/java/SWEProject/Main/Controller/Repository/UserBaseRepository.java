package SWEProject.Main.Controller.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import SWEProject.Main.Controller.Entities.User;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, String>{

    T findOneByUsernameAndPassword(String username, String password);
    boolean existsByUsernameAndPassword(String username, String password);
    T findOneByUsername(String username);
    @Query("update User u set u.balance = u.balance-:price where u.username = :username")
    void updateBalance(@Param("price") double price, @Param("username") String username);

}
