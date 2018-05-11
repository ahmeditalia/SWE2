package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.NormalUser;

public interface NormalUserRepository extends UserBaseRepository<NormalUser> {
    NormalUser findOneByUsername(String username);

}
