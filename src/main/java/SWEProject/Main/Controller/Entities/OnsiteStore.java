package SWEProject.Main.Controller.Entities;


import javax.persistence.Entity;
@Entity
public class OnsiteStore  extends Store {


    public OnsiteStore(String storeName) {
        super(storeName);
    }
	public OnsiteStore(String storeName, StoreOwner storeOwner) {
		this.storeName = storeName;
		this.storeOwner = storeOwner;
	}
	
	public OnsiteStore(String storeName, StoreOwner storeOwner, String location, String type) {
		this.storeName = storeName;
		this.storeOwner = storeOwner;
		this.location = location;
		this.type = type;
	}
    public OnsiteStore(){}

}
