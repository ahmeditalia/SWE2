package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.StoreController;

import javax.persistence.Entity;

@Entity
public class AddProductCommand extends Command{


    public AddProductCommand() {}

    public AddProductCommand(StoreProduct product , String description)
    {
        this.product = product;
        this.description = description;
    }

    public void execute(StoreController storeController){

        Store store = storeController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        SystemProduct product1 = storeController.sysProRepo.findOneByName(product.getName());
        product = new StoreProduct(product.getQuantity(), product.getPrice(), store);
        product.setName(product1.getName());
        product.setBrand(product1.getBrand());
        product.setType(product1.getType());
        storeController.commandRepo.save(this);
        store.addCommand(this);
        storeController.storeProductRepo.save(product);
        store.addProduct(product);
    }

    public void undo(StoreController storeController){
    	Store store = storeController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.commands.remove(this);
        storeController.commandRepo.delete(this);
    }
}

