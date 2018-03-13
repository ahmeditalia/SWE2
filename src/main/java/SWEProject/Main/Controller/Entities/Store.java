package SWEProject.Main.Controller.Entities;


import javax.persistence.*;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Store_Type")

public abstract class Store {
    @Id
    protected StoreIdentity storeId;

    @OneToMany(mappedBy="store",cascade=CascadeType.ALL)
    List<StoreProduct> products;
    public Store() {

    }

    public Store(StoreIdentity storeName) {
        this.storeId = storeName;
    }

    public StoreIdentity getStoreId() {
        return storeId;
    }

    public void setStoreId(StoreIdentity storeName) {
        this.storeId = storeName;
    }

    public List<StoreProduct> getProducts() {
        return products;
    }

    public void setProducts(List<StoreProduct> products) {
        this.products = products;
    }
}
