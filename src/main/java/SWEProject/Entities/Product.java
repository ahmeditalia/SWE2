package SWEProject.Entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private double price;
    private String brand;
    private String category;
    private int quantity;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product(String name, int id, double price, String brand, String category, int quantity, String type) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.type = type;
    }
    public Product(){
        this.name="";
        //this.id;
        this.price=0;
        this.brand ="";
        this.category ="";
        this.quantity =0;
        this.type ="";
    }
}
