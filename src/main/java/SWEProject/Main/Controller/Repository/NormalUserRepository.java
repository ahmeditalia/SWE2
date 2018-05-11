package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Admin;
import SWEProject.Main.Controller.Entities.NormalUser;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NormalUserRepository extends UserBaseRepository<NormalUser> {
    NormalUser findOneByUsername(String username);

}
