package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
@Entity(name = "OnlineStore")

public class OnlineStore extends Store {

	public OnlineStore(StoreIdentity storeName) {
		super(storeName);
	}
	public OnlineStore(){}
}
