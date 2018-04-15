package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

@Entity
public class StoreProduct extends Product {

    @NotNull
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "storeName")
    private Store store;
    @ManyToMany(mappedBy = "storeProducts", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cart> carts;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StoreProduct(){

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StoreProduct(int quantity, double price, Store store) {
        this.quantity = quantity;
        this.price = price;
        this.store = store;
    }
    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
    public void addCart(Cart cart){
        carts.add(cart);
    }

}
