package SWEProject.Main.Controller.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductStore {

    @EmbeddedId
    private ProductStoreID id;

}
