package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.CommandRepository;
import SWEProject.Main.Controller.Repository.StoreProductRepository;
import SWEProject.Main.Controller.Repository.StoreRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommandController {
	
	
    public StoreProductRepository storeProRepo;
    public CommandRepository commandRepo;
    public StoreRepository storeRepo;
    public SystemProductRepository sysProRepo;
    
    @Autowired
    public CommandController(StoreProductRepository storeProRepo, CommandRepository commandRepo,
			StoreRepository storeRepo, SystemProductRepository sysProRepo) {
		this.storeProRepo = storeProRepo;
		this.commandRepo = commandRepo;
		this.storeRepo = storeRepo;
		this.sysProRepo = sysProRepo;
	}

	@RequestMapping("/add-product-store/{storeName}")
    @ResponseBody
    public boolean addProduct(@RequestBody() StoreProduct product, @PathVariable("storeName") String sname) {

        Store store = storeRepo.findOneByStoreName(sname);
        if(!storeProRepo.existsByNameAndStoreAndExist(product.getName(),store,"exist")){
            product.setStore(store);
            String desc = "add product " + product.getName() + " to store " + store.getStoreName()
                    + " with quantity " + product.getQuantity() + " and price " + product.getPrice();
            AddProductCommand add = new AddProductCommand(product, desc);
            add.execute(this);
            return true;
        }
        else {
        	return false;
        }
    }

    @RequestMapping("/delete-store-product")
    @ResponseBody
    public void deleteProduct(@RequestParam("id") int productid) {

        StoreProduct product = storeProRepo.findOne(productid);
        String desc = "delete product " + product.getName() + " from store " + product.getStore().getStoreName();
        DeleteProductCommand deleteProduct = new DeleteProductCommand(product,desc);
        deleteProduct.execute(this);
    }

    @RequestMapping("/edit-store-product")
    @ResponseBody
    public void editProduct(@RequestParam("id") int productid, @RequestParam("quantity") int quantity,
                            @RequestParam("price") double price) {

        StoreProduct product = storeProRepo.findOne(productid);
        String desc = "edit product " + product.getName() + " with quntity " + product.getQuantity() + " and price "
                + product.getPrice();
        product.setQuantity(quantity);
        product.setPrice(price);
        EditProductCommand editProduct = new EditProductCommand(product,desc);
        editProduct.execute(this);
    }

    @RequestMapping("/undo")
    @ResponseBody
    public void undo(@RequestParam("id") int commandId){

        Command command = commandRepo.findOne(commandId);
        command.undo(this);
    }

}
