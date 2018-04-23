package SWEProject.Main.Controller.Entities;

import SWEProject.Main.Controller.CommandController;

import javax.persistence.Entity;

@Entity
public class EditProductCommand extends Command {

    public EditProductCommand() {}

    public EditProductCommand(StoreProduct product, String description) {

        this.product = product;
        this.description = description;
    }

    @Override
    public void execute(CommandController commandController) {

        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.addCommand(this);
        commandController.commandRepo.save(this);
        commandController.storeProRepo.save(product);
    }

    @Override
    public void undo(CommandController commandController) {

        Store store = commandController.storeRepo.findOneByStoreName(product.getStore().getStoreName());
        store.commands.remove(this);
        String [] strings = description.split(" ");
        product.setQuantity(Integer.parseInt(strings[5]));
        product.setPrice(Double.parseDouble(strings[8]));
        commandController.storeProRepo.save(product);
        commandController.commandRepo.delete(this);
    }
}
