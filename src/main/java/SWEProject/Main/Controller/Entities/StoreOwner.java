package SWEProject.Main.Controller.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class StoreOwner extends User{
	@OneToMany(mappedBy="storeOwner",cascade=CascadeType.ALL)
	List<Store> stores;
	@OneToOne(cascade = CascadeType.ALL)
	Statistics statistics;
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
	public void addStore(Store store)
	{
		stores.add(store);
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
}
