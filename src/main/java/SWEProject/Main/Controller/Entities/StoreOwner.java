package SWEProject.Main.Controller.Entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class StoreOwner extends User{
	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL)
	List<OnlineStore> stores;
	public StoreOwner() {
	}
	public StoreOwner(User user)
	{
		this.username=user.username;
		this.password=user.password;
		this.email=user.email;
	}
	public StoreOwner(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
