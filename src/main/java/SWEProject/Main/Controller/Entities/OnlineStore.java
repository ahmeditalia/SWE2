package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
@Entity(name = "OnlineStore")

public class OnlineStore extends Store {

	public OnlineStore(String storeName) {
		super(storeName);
	}
	public OnlineStore(String storeName, StoreOwner storeOwner) {
		this.storeName = storeName;
		this.storeOwner = storeOwner;
	}
	public OnlineStore(){}
}
