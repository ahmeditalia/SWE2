package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class StoreProduct implements Product {

    private Integer id;
    private String name;
    @NotNull
    private double price;
    private Brand brand;
    @NotNull
    private int quantity;
    private String type;
    private ProductStore productStore;

    public StoreProduct() {}

    public StoreProduct(String name, double price, Brand brand, int quantity, String type) {

        this.name = name;
        this.price = price;
        this.brand = brand;
        this.quantity = quantity;
        this.type = type;
    }

    @Override
    public Integer getId() { return id; }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public ProductStore getProductStore() { return productStore; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public Brand getBrand() {
        return brand;
    }

    @Override
    public void setBrand(Brand brand) { this.brand = brand; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) { this.type = type; }
}
