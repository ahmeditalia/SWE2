package SWEProject.Main.Controller.Entities;


import javax.persistence.Entity;
@Entity

public class OnlineStore extends Store {

	public OnlineStore(String storeName) {
		super(storeName);
	}
	public OnlineStore(String storeName, StoreOwner storeOwner) {
		this.storeName = storeName;
		this.storeOwner = storeOwner;
		this.status="Onhold";
	}
	public OnlineStore(String storeName, StoreOwner storeOwner, String location, String type) {
		this.storeName = storeName;
		this.storeOwner = storeOwner;
		this.location = location;
		this.type = type;
		this.status="Onhold";
	}
	public OnlineStore(){}
}
