package SWEProject.Main.Controller.Entities;

import javax.persistence.Id;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import SWEProject.Main.Controller.StoreIdentity;

public class OnlineStore implements Store {
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

    public OnlineStore(StoreIdentity storeIdentity, String storeType) {
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


}
