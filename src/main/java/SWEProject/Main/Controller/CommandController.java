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
	
	@Autowired
    public StoreProductRepository storeProRepo;

	@Autowired
    public CommandRepository commandRepo;

	@Autowired
    public StoreRepository storeRepo;

    @Autowired
    public SystemProductRepository sysProRepo;

    @RequestMapping("/add-product-store/{storeName}")
    @ResponseBody
    public void addProduct(@RequestBody() StoreProduct product, @PathVariable("storeName") String sname) {

        boolean exist = false;
        Store store = storeRepo.findOneByStoreName(sname);

        for (int i = 0; i < store.getProducts().size(); i++) {

            if (store.getProducts().get(i).getName().equals(product.getName())) {

                exist = true;
                break;
            }
        }

        if (!exist) {

            product.setStore(store);
            AddProductCommand add = new AddProductCommand(product,"added product");
            add.execute(this);
        }
    }

    @RequestMapping("/delete-store-product")
    @ResponseBody
    public void deleteProduct(@RequestParam("id") int productid) {

        StoreProduct product = storeProRepo.findOne(productid);
        DeleteProductCommand deleteProduct = new DeleteProductCommand(product,"deleted product");
        deleteProduct.execute(this);
    }

    @RequestMapping("/edit-store-product")
    @ResponseBody
    public void editProduct(@RequestParam("id") int productid, @RequestParam("quantity") int quantity,
                            @RequestParam("price") double price) {

        StoreProduct deletedProduct = storeProRepo.findOne(productid);
        StoreProduct product = new StoreProduct(quantity,price,deletedProduct.getStore());
        product.setExist("exist");
        product.setName(deletedProduct.getName());
        product.setType(deletedProduct.getType());
        product.setBrand(deletedProduct.getBrand());
        product.setCarts(deletedProduct.getCarts());

        EditProductCommand editProduct = new EditProductCommand("edited Product",product,deletedProduct);
        editProduct.execute(this);
    }

    @RequestMapping("/undo")
    @ResponseBody
    public void undo(@RequestParam("id") int commandId){

        Command command = commandRepo.findOne(commandId);
        command.undo(this);
    }

}
