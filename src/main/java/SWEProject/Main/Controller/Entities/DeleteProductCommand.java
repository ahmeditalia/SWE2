package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.CommandController;
import SWEProject.Main.Controller.StoreController;

import javax.persistence.Entity;

@Entity
public class DeleteProductCommand extends Command {


    public DeleteProductCommand() {}

    public DeleteProductCommand(StoreProduct product, String description)
    {
        this.product = product;
        this.description = description;
    }

    public void execute(CommandController commandController){

        product.setExist("deleted");
        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.commands.add(this);
        commandController.commandRepo.save(this);
        commandController.storeProRepo.save(product);
    }

    public void undo(CommandController commandController){

        product.setExist("exist");
        commandController.storeProRepo.save(product);
        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.commands.remove(this);
        commandController.commandRepo.delete(this);
    }
}
