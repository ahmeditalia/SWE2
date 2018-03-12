package SWEProject.Main.Controller.Entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ProductStore {

    @EmbeddedId
    private ProductStoreID id;

    @NotNull
    private int views;

    @NotNull
    private int buyers;

    public ProductStore() {}

    public ProductStoreID getId() { return id; }

    public void setId(ProductStoreID id) { this.id = id; }

    public int getViews() { return views; }

    public void setViews(int views) { this.views = views; }

    public int getBuyers() { return buyers; }

    public void setBuyers(int buyers) { this.buyers = buyers; }
}
