package SWEProject.Main.Controller.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Statistics implements Operations {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    public int numUserView;
    public int numUserBuy;
    public int soldProducts;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    public Store store;
    public Statistics() {
        this.numUserView = 0;
        this.numUserBuy = 0;
        this.soldProducts = 0;
    }

    public Statistics(int numUserView, int numUserBuy, int soldProducts) {
        this.numUserView = numUserView;
        this.numUserBuy = numUserBuy;
        this.soldProducts = soldProducts;
    }

    public int getNumUserView() {
        return numUserView;
    }

    public void setNumUserView(int numUserView) {
        this.numUserView = numUserView;
    }

    public int getNumUserBuy() {
        return numUserBuy;
    }

    public void setNumUserBuy(int numUserBuy) {
        this.numUserBuy = numUserBuy;
    }

    public int getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(int soldProducts) {
        this.soldProducts = soldProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Store getStoreOwner() {
        return store;
    }

    public void setStoreOwner(Store store) {
        this.store = store;
    }

    @Override
    public void increamentUserViews() {
        numUserView++;
    }

    @Override
    public void increamentUserBuy() {
        numUserBuy++;
    }

    @Override
    public void increamentSoldProducts(int numProducts) {
        soldProducts+=numProducts;
    }
}




