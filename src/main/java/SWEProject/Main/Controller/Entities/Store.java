package SWEProject.Main.Controller.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Store_Type")

public abstract class Store {
    @Id
    protected String storeId;

    @OneToMany(mappedBy="store",cascade=CascadeType.ALL)
    List<StoreProduct> products;
    public Store() {

    }
    @NotNull
    @ManyToOne
    @JoinColumn(name="storeOwnerId")
    private StoreOwner storeOwner;

    public Store(String storeName) {
        this.storeId = storeName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeName) {
        this.storeId = storeName;
    }

    public List<StoreProduct> getProducts() {
        return products;
    }

    public void setProducts(List<StoreProduct> products) {
        this.products = products;
    }

    public void addProduct(StoreProduct s){
        products.add(s);
    }
}
