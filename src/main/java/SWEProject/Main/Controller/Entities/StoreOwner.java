package SWEProject.Main.Controller.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class StoreOwner extends User{
	@OneToMany(mappedBy="storeOwner",cascade=CascadeType.ALL)
	@JsonIgnore
	List<Store> stores;
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	public StoreOwner() {
		stores=new ArrayList<Store>();
		balance=0;
		discount.addDiscount(StoreOwnerDiscount.class);
	}
	public StoreOwner(User user)
	{
		stores=new ArrayList<Store>();
		this.username=user.username;
		this.password=user.password;
		this.email=user.email;
		discount.addDiscount(StoreOwnerDiscount.class);
	}
	public StoreOwner(String username, String email, String password) {
		stores=new ArrayList<Store>();
		this.username = username;
		this.email = email;
		this.password = password;
		discount.addDiscount(StoreOwnerDiscount.class);
	}
	public void addStore(Store store)
	{
		stores.add(store);
	}
}
