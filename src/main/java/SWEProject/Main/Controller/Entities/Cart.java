package SWEProject.Main.Controller.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    //@JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
    private List<StoreProduct> storeProducts;
    public Cart(User user){
        storeProducts=new ArrayList<StoreProduct>();
        this.user=user;
    }
    public Cart(){
        storeProducts=new ArrayList<StoreProduct>();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<StoreProduct> getStoreProducts() { return storeProducts; }
    public void setStoreProducts(List<StoreProduct> storeProducts) { this.storeProducts = storeProducts; }
    public void addProduct(StoreProduct storeProduct){
        if(!storeProducts.contains(storeProduct))
            storeProducts.add(storeProduct);
    }
    public void removeProduct(StoreProduct storeProduct){
        storeProducts.remove(storeProduct);
    }
}