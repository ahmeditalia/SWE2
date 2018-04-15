package SWEProject.Main.Controller.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class DeletedStoreProduct {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;

    @OneToOne
    private DeleteProductCommand deleteProduct;

    @NotNull
    private StoreProduct product;

    public DeletedStoreProduct() {}

    public DeletedStoreProduct(StoreProduct product) { this.product = product; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public DeleteProductCommand getDeleteProduct() { return deleteProduct; }

    public void setDeleteProduct(DeleteProductCommand deleteProduct) { this.deleteProduct = deleteProduct; }

    public StoreProduct getProduct() { return product; }

    public void setProduct(StoreProduct product) { this.product = product; }
}
