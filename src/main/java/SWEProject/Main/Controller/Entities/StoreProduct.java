package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class StoreProduct extends Product {

    @NotNull
    private int quantity;
    private String type;

    @ManyToOne
    @JoinColumn(name = "storeName", insertable = false, updatable = false)
    private Store store;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StoreProduct(){}
}
