package SWEProject.Main.Controller;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class StoreIdentity implements Serializable  {
    @NotNull
    private String storeName;
    //@NotNull
    //private StoreOwner storeOwner;


   /* public StoreOwner getStoreOwner() {
        return storeOwner;
    }*/

   /* public void setStoreOwner(StoreOwner storeOwner) {
        this.storeOwner = storeOwner;
    }*/

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public StoreIdentity(String storeName/*StoreOwner*/) {
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
        /*if (this.storeOwner != other.storeOwner) {
            return false;
        }*/
        return true;
    }
}
