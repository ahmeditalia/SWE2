package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.StoreController;

import javax.persistence.Entity;

@Entity
public class DeleteProductCommand extends Command {


    public DeleteProductCommand() {}

    public DeleteProductCommand(StoreProduct product, String decription)
    {
        this.product = product;
        this.description = decription;
    }

    public void execute(StoreController storeController){

        StoreProduct storeProduct = new StoreProduct(product.getQuantity(), product.getPrice(), product.getStore());
        storeProduct.setId(product.id);
        storeProduct.setBrand(product.brand);
        storeProduct.setName(product.name);
        storeProduct.setType(product.getType());
        storeController.commandRepo.save(this);
        storeController.storeProductRepo.delete(storeProduct);
    }

    public void undo(StoreController storeController){

        storeController.storeProductRepo.save(product);
        storeController.commandRepo.delete(this);
    }
}
