package SWEProject.Main.Controller.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;
@Entity
@Inheritance
public class Store {
	@Id
    protected String storeName;
    @OneToMany(mappedBy="store",cascade=CascadeType.ALL)
    @JsonIgnore
    protected List<StoreProduct> products;

    @NotNull
    @ManyToOne
    @JoinColumn(name="storeOwnerId")
    protected StoreOwner storeOwner;
    protected String location;
    protected String type;
    protected String status;
    @JsonIgnore
	@OneToOne(mappedBy="store",cascade = CascadeType.ALL)
	protected Statistics statistics;

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL)
	List<Command> commands;

	public Store() {
    	products=new ArrayList<StoreProduct>();
    }
	public Store(String storeName) {

		commands = new ArrayList<Command>();
    	products = new ArrayList<StoreProduct>();
		this.storeName = storeName;
	}
	public Store(String storeName, StoreOwner storeOwner) {

		commands = new ArrayList<Command>();
    	products = new ArrayList<StoreProduct>();
		this.storeName = storeName;
		this.storeOwner = storeOwner;
	}
	public Store(String storeName, StoreOwner storeOwner, String location, String type, String status) {

		commands = new ArrayList<Command>();
		products = new ArrayList<StoreProduct>();
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

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
		statistics.setStore(this);
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

	public List<Command> getCommands() { return commands; }

	public void setCommands(List<Command> commands) { this.commands = commands; }

	public void addCommand(Command command){ commands.add(command); }

}
