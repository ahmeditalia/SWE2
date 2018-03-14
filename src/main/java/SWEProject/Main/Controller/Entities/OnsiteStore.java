package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
@Entity(name = "OnsiteStore")
public class OnsiteStore  extends Store {


    public OnsiteStore(String storeName) {
        super(storeName);
    }
    public OnsiteStore(){}

}
