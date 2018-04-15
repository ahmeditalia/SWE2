package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.StoreController;

import javax.persistence.Entity;

@Entity
public class DeleteProductCommand extends Command {

    public DeleteProductCommand(StoreProduct product, String description)
    {
        this.product = product;
        this.description = description;
    }

    public void execute(StoreController storeController){

        DeletedStoreProduct deleteProduct = new DeletedStoreProduct(product);
        storeController.deletedProductRepo.save(deleteProduct);
        storeController.storeProductRepo.delete(product);
    }

    public void undo(StoreController storeController){

        product = storeController.deletedProductRepo.findProductByDeleteProduct(this.id);
        storeController.storeProductRepo.save(product);
    }
}
