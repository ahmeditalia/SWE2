package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.CommandController;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class EditProductCommand extends Command {

    @OneToOne
    private StoreProduct deletedProduct;

    public EditProductCommand() {}

    public EditProductCommand(String description, StoreProduct product, StoreProduct deletedProduct) {

        this.product = product;
        this.description = description;
        this.deletedProduct = deletedProduct;
    }

    public StoreProduct getDeletedProduct() { return deletedProduct; }

    public void setDeletedProduct(StoreProduct deletedProduct) { this.deletedProduct = deletedProduct; }

    @Override
    public void execute(CommandController commandController) {

        deletedProduct.setExist("deleted");
        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.addCommand(this);
        store.addProduct(product);
        commandController.commandRepo.save(this);
        commandController.storeProRepo.save(product);
        commandController.storeProRepo.save(deletedProduct);
    }

    @Override
    public void undo(CommandController commandController) {

        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.commands.remove(this);
        deletedProduct.setExist("exist");
        commandController.storeProRepo.save(deletedProduct);
        store.addProduct(deletedProduct);
        commandController.commandRepo.delete(this);
    }
}
