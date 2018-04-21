package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.CommandController;
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

    public void execute(CommandController commandController){

        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        SystemProduct product1 = commandController.sysProRepo.findOneByName(product.getName());
        product = new StoreProduct(product.getQuantity(), product.getPrice(), store);
        product.setName(product1.getName());
        product.setBrand(product1.getBrand());
        product.setType(product1.getType());
        commandController.commandRepo.save(this);
        store.addCommand(this);
        commandController.storeProRepo.save(product);
        store.addProduct(product);
    }

    public void undo(CommandController commandController){

        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.commands.remove(this);
        commandController.commandRepo.delete(this);
    }
}

