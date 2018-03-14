package SWEProject.Main.Controller.Entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class StoreIdentity implements Serializable  {
    private StoreOwner storeOwner;

    @NotNull
    private String storeName;

    public StoreIdentity(StoreOwner storeOwner, String storeName) {
        this.storeOwner = storeOwner;
        this.storeName = storeName;
    }
    public StoreIdentity(){

    }
    public StoreOwner getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(StoreOwner storeOwner) {
        this.storeOwner = storeOwner;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!StoreIdentity.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final StoreIdentity other = (StoreIdentity) obj;
        if ((this.storeName == null) ? (other.storeName != null) : !this.storeName.equals(other.storeName)) {
            return false;
        }
        if (!this.storeOwner .equals( other.storeOwner)) {
            return false;
        }
        return true;
    }
}
