package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
	public Admin() {
	}
	public Admin(User user)
	{
		this.username=user.username;
		this.password=user.password;
		this.email=user.email;
	}
}
