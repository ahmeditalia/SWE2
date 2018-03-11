package SWEProject.Main.Controller;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class StoreIdentity implements Serializable  {
    @NotNull
    private String name;
    //@NotNull
    //private StoreOwner storeOwner;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   /* public StoreOwner getStoreOwner() {
        return storeOwner;
    }*/

   /* public void setStoreOwner(StoreOwner storeOwner) {
        this.storeOwner = storeOwner;
    }*/

    public StoreIdentity(String name/*,StoreOwner storeOwner*/) {
        this.name = name;
        //this.storeOwner=storeOwner;
    }

}
