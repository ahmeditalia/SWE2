package SWEProject.Main.Controller.Entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class StoreIdentity implements Serializable  {
	@NotNull
    private String storeOwnerId;

    @NotNull
    private String storeName;

    public StoreIdentity(String storeOwnerId, String storeName) {
        this.storeOwnerId = storeOwnerId;
        this.storeName = storeName;
    }
    public StoreIdentity(){

    }
    public String getStoreOwnerId() {
        return storeOwnerId;
    }

    public void setStoreOwnerId(String storeOwnerId) {
        this.storeOwnerId = storeOwnerId;
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
        if (!this.storeOwnerId .equals( other.storeOwnerId)) {
            return false;
        }
        return true;
    }
}
