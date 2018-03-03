package SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public interface User {
	@Id
	public Integer id=0;
	
	public String username="";
	public String email="";
	public String Password="";
}
