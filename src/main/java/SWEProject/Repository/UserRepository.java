package SWEProject.Repository;

import org.springframework.data.repository.CrudRepository;

import SWEProject.Entities.User;

public interface UserRepository extends CrudRepository<User, String>{

}
