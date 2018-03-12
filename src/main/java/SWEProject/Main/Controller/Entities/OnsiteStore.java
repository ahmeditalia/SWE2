package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.StoreIdentity;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;

public class OnsiteStore  implements Store {

    @EmbeddedId
    private StoreIdentity storeIdentity;
    private String storeType;

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
