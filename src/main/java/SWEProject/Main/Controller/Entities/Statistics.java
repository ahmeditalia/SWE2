package SWEProject.Main.Controller.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Statistics implements Operations {
    public int numUserView;
    public int numUserBuy;
    public int soldProducts;
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

    @Override
    public void increamentUserViews() {
        numUserView++;
    }

    @Override
    public void increamentUserBuy() {
        numUserBuy++;
    }

    @Override
    public void increamentSoldProducts() {
        soldProducts++;
    }
}
