package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.StoreController;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public abstract class Command {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    protected StoreProduct product;

    public StoreProduct getProduct() { return product; }

    public void setProduct(StoreProduct product) { this.product = product; }

    public void execute(StoreController storeController){}

    public void undo(StoreController storeController){}

}
