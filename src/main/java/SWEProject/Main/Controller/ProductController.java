package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.Product;
import SWEProject.Main.Controller.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository repo;
    @GetMapping("/add-product")
    public String showproductsform(Model model){
        model.addAttribute("product",new Product());
        return "add-product";
    }
    @PostMapping("/add-product")
    public String addProduct(Model model, @ModelAttribute Product product){
        repo.save(product);
        Iterable<Product> pro=repo.findAll();
    	List<Product> products=new ArrayList<Product>();
    	for(Product p:pro)
    	{
    		products.add(p);
    	}
    	model.addAttribute("products",products);
        return "show-all-product";
    }
    @RequestMapping("/show-all-product")
    public String showAllProducts(Model model)
    {
    	Iterable<Product> pro=repo.findAll();
    	List<Product> products=new ArrayList<Product>();
    	for(Product p:pro)
    	{
    		products.add(p);
    	}
    	model.addAttribute("products",products);
    	return "show-all-product";
    }
}
