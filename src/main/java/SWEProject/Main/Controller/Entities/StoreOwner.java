package SWEProject.Main.Controller.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class StoreOwner extends User{
	@OneToMany(mappedBy="storeOwner",cascade=CascadeType.ALL)
	List<Store> stores;
	public StoreOwner() {
		stores=new ArrayList<Store>();
	}
	public StoreOwner(User user)
	{
		stores=new ArrayList<Store>();
		this.username=user.username;
		this.password=user.password;
		this.email=user.email;
	}
	public StoreOwner(String username, String email, String password) {
		stores=new ArrayList<Store>();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public void addStore(Store store,String type)
	{
		store=Creator.getInstance().createStore(type, store, this);
		stores.add(store);
	}
}
