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

	public StoreOwner() {
		super();
		stores=new ArrayList<Store>();
		discount.addDiscount("StoreOwnerDiscount");
	}
	public StoreOwner(User user)
	{
		super(user.username, user.password, user.email);
		stores=new ArrayList<Store>();
		discount.addDiscount("StoreOwnerDiscount");
	}
	public StoreOwner(String username, String email, String password) {
		super(username, password, email);
		stores=new ArrayList<Store>();
		discount.addDiscount("StoreOwnerDiscount");
	}
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	public void addStore(Store store)
	{
		stores.add(store);
	}
}
