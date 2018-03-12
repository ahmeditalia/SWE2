package SWEProject.Main.Controller.Entities;

import javax.persistence.*;

@Entity
public class SystemProduct implements Product{

    private ProductStore productStore;
    private Integer id;
    private String name;
    private Brand brand;
    private String type;

    @Override
    public Integer getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public ProductStore getProductStore() { return productStore; }

    @Override
    public Brand getBrand() { return brand; }

    @Override
    public void setBrand(Brand brand) { this.brand = brand; }

    @Override
    public String getType() { return type; }

    @Override
    public void setType(String type) { this.type = type; }
}
