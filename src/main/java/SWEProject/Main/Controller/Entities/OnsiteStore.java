package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Entity(name = "OnsiteStore")
public class OnsiteStore  extends Store {


    public OnsiteStore(StoreIdentity storeName) {
        super(storeName);
    }
    public OnsiteStore(){}

}
