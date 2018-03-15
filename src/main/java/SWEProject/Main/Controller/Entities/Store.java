package SWEProject.Main.Controller.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Store_Type")

public class Store {
   
	@Id
    protected String storeName;

    @OneToMany(mappedBy="store",cascade=CascadeType.ALL)
    protected List<StoreProduct> products;

    @NotNull
    @ManyToOne
    @JoinColumn(name="storeOwnerId")
    protected StoreOwner storeOwner;
    protected String location;
    protected String type;
    
    public Store() {

    }
	public Store(String storeName) {
		this.storeName = storeName;
	}
	public Store(String storeName, StoreOwner storeOwner) {
		this.storeName = storeName;
		this.storeOwner = storeOwner;
	}
	
	
	
	public Store(String storeName, StoreOwner storeOwner, String location, String type) {
		this.storeName = storeName;
		this.storeOwner = storeOwner;
		this.location = location;
		this.type = type;
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
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<StoreProduct> getProducts() {
        return products;
    }

    public void setProducts(List<StoreProduct> products) {
        this.products = products;
    }
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
