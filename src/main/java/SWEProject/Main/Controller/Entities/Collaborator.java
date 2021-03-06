
package SWEProject.Main.Controller.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Collaborator extends User {

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private StoreOwner storeOwner;
    public Collaborator(){}

    public Collaborator(User user) {
        super(user.username,user.password,user.email);
    }

    public StoreOwner getStoreOwner() { return storeOwner; }

    public void setStoreOwner(StoreOwner storeOwner) { this.storeOwner = storeOwner; }
}
