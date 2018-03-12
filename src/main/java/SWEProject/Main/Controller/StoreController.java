package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Product;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Repository.ProductRepository;
import SWEProject.Main.Controller.Repository.StoreRepository;
import SWEProject.Main.Controller.Entities.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class StoreController {
    @Autowired
    private StoreRepository srepo;
    private ProductRepository prepo;

    @GetMapping("/add-product-store")
    public String showproductsform(Model model){
        model.addAttribute("product",new StoreProduct());
        return "add-product-store";
    }


    @PostMapping("/add-product-store")
    public String addProduct(@ModelAttribute Product product){
        prepo.save(product);
        return "redirect:/show-all-product-store";
    }


    /*@RequestMapping("/{oname}/{sname}/show-all-product-store/")
    public String showAllProducts(Model model, Store store, @PathVariable String oname,@PathVariable String sname)
    {
        Iterable<Product> pro=prepo.findAll();
        List<Product> products=new ArrayList<Product>();
        for(Product p:pro)
        {
            products.add(p);
        }
        model.addAttribute("products",products);
        return "show-all-product-store";
    }*/
}
