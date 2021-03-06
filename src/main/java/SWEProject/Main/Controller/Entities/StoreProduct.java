package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
public class StoreProduct extends Product {

    @NotNull
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "storeName")
    private Store store;
    @JsonIgnore
    @ManyToMany//(mappedBy="storeProducts")
    private List<Cart> carts;
    @NotNull
    private String exist;

    public String getExist() { return exist; }

    public void setExist(String exist) { this.exist = exist; }

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

        carts = new ArrayList<Cart>();
        exist = "exist";
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public StoreProduct(int quantity, double price, Store store) {

        carts = new ArrayList<Cart>();
        this.quantity = quantity;
        this.price = price;
        this.store = store;
        exist = "exist";
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void addCart(Cart cart){
        if(!carts.contains(cart))
            carts.add(cart);
    }
    public void removeCart(Cart cart){
        carts.remove(cart);
    }
    @PreRemove
    public void preremove()
    {
    	store.products.remove(this);
    	for(Cart c:carts)
    	{
    		c.getStoreProducts().remove(this);
    	}
    	store=null;
    	carts.clear();
    }
}
