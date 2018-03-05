package SWEProject.Main.Controller.Repository;

import org.springframework.transaction.annotation.Transactional;

import SWEProject.Main.Controller.Entities.Admin;

@Transactional
public interface AdminRepository extends UserBaseRepository<Admin>{

}
