package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.StoreIdentity;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OnsiteStore  implements Store {

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

}
