package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.CommandController;

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
        commandController.storeProRepo.save(product);
        store.addCommand(this);
        store.addProduct(product);
        commandController.commandRepo.save(this);
    }

    public void undo(CommandController commandController){

        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.commands.remove(this);
        commandController.commandRepo.delete(this);
        commandController.storeProRepo.delete(product);
    }
}

