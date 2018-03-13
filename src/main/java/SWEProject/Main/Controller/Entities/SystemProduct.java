package SWEProject.Main.Controller.Entities;

import javax.persistence.*;

@Entity
public class SystemProduct implements Product{

    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name="Brand_ID")
    private Brand brand;
    private String type;
    @ManyToOne
    @JoinColumn(name="Store_ID")
    private Store store;

    @Override
    public Integer getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public Brand getBrand() { return brand; }

    @Override
    public void setBrand(Brand brand) { this.brand = brand; }

    @Override
    public String getType() { return type; }

    @Override
    public void setType(String type) { this.type = type; }

    @Override
    public Store getStore() { return store; }

    @Override
    public void setStore(Store store) { this.store = store; }

}
