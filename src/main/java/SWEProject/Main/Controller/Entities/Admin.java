package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
	public Admin() {
		super();
	}
	public Admin(User user)
	{
    	super(user.username, user.password, user.email);
	}
}
