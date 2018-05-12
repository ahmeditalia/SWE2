package SWEProject.Main.Controller.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class StoreOwner extends User{
	@OneToMany(mappedBy="storeOwner",cascade=CascadeType.ALL)
	@JsonIgnore
	List<Store> stores;

	public StoreOwner() {
		super();
		stores=new ArrayList<Store>();
		discount=new StoreOwnerDiscount(discount);
	}
	public StoreOwner(User user)
	{
		super(user.username, user.password, user.email);
		stores=new ArrayList<Store>();
		discount=new StoreOwnerDiscount(discount);
	}
	public StoreOwner(String username, String email, String password) {
		super(username, password, email);
		stores=new ArrayList<Store>();
		discount=new StoreOwnerDiscount(discount);
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
