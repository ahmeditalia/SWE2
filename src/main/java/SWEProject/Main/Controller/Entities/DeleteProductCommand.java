package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.StoreController;

import javax.persistence.Entity;

@Entity
public class DeleteProductCommand extends Command {

    public DeleteProductCommand(StoreProduct product/*, String desc*/)
    {
        this.product = product;
        //this.desc = desc;
    }

    public void execute(StoreController storeController){

        StoreProduct storeProduct = new StoreProduct(product.getQuantity(), product.getPrice(), product.getStore());
        storeProduct.setId(product.id);
        storeProduct.setBrand(product.brand);
        storeProduct.setName(product.name);
        storeProduct.setType(product.getType());

        storeController.storeProductRepo.delete(storeProduct);
    }

    public void undo(StoreController storeController){

        storeController.storeProductRepo.save(product);
    }
}
