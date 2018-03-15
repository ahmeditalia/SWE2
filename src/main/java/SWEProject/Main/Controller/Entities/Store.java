package SWEProject.Main.Controller.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
@Entity
@Inheritance

public class Store {
   

    protected String storeName;

    protected List<StoreProduct> products;

   
    protected StoreOwner storeOwner;
    protected String location;
    protected String type;
    protected String status;
    
    public Store() {
    	products=new ArrayList<StoreProduct>();
    }
	public Store(String storeName) {
    	products=new ArrayList<StoreProduct>();
		this.storeName = storeName;
	}
	public Store(String storeName, StoreOwner storeOwner) {
    	products=new ArrayList<StoreProduct>();
		this.storeName = storeName;
		this.storeOwner = storeOwner;
	}
	public Store(String storeName, StoreOwner storeOwner, String location, String type, String status) {
    	products=new ArrayList<StoreProduct>();
		this.storeName = storeName;
		this.storeOwner = storeOwner;
		this.location = location;
		this.type = type;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Id
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

    @OneToMany(mappedBy="store",cascade=CascadeType.ALL)
	public List<StoreProduct> getProducts() {
        return products;
    }

    public void setProducts(List<StoreProduct> products) {
        this.products = products;
    }
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="storeOwnerId")
    public StoreOwner getStoreOwner() {
		return storeOwner;
	}

	public void setStoreOwner(StoreOwner storeOwner) {
		this.storeOwner = storeOwner;
	}
    public void addProduct(StoreProduct s){
        products.add(s);
    }
}
