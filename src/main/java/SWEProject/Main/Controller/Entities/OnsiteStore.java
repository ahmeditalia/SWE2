package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class OnsiteStore  implements Store {

	@Id
	private String storeName;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="StoreOwner")
	private StoreOwner owner;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public StoreOwner getOwner() {
		return owner;
	}

	public void setOwner(StoreOwner owner) {
		this.owner = owner;
	}

	public OnsiteStore() {
	}
	public OnsiteStore(String storeName, StoreOwner owner) {
		super();
		this.storeName = storeName;
		this.owner = owner;
	}
	

	/*
    @EmbeddedId
    private StoreIdentity storeIdentity;
    private String storeType;
    @ManyToOne
    @JoinColumn(name = "id")
    private ProductStoreID id;

    public ProductStoreID getId() {
        return id;
    }

    public void setId(ProductStoreID id) {
        this.id = id;
    }

    public OnsiteStore(StoreIdentity storeIdentity, String storeType) {
        this.storeIdentity = storeIdentity;
        this.storeType = storeType;
    }

    public StoreIdentity getStoreIdentity() {
        return storeIdentity;
    }

    public void setStoreIdentity(StoreIdentity storeIdentity) {
        this.storeIdentity = storeIdentity;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }
*/


}
