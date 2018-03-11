package SWEProject.Main.Controller.Entities;

import javax.persistence.Id;
import javax.persistence.EmbeddedId;
import SWEProject.Main.Controller.StoreIdentity;

public class OnlineStore implements Store {

    @Id
    @EmbeddedId
    private StoreIdentity storeIdentity;
    private String storeType;

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
