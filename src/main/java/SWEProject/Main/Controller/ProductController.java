package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.Product;
import SWEProject.Main.Controller.Entities.SystemProduct;
import SWEProject.Main.Controller.Repository.BrandRepository;
import SWEProject.Main.Controller.Repository.StoreProductRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;

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
    private SystemProductRepository sysProductrepo;
    @Autowired
    private StoreProductRepository storeProductRepo;
    @Autowired
    private BrandRepository brandRepository;
    
    
    @GetMapping("/add-product-to-system")
    public String showProductForm(Model model){
        model.addAttribute("product",new SystemProduct());
        return "add-product-to-system";
    }
    
    
    @PostMapping("/add-product-to-system")
    public String addProduct(@ModelAttribute SystemProduct product){
        Brand brand = new Brand();
        brand.setName(product.getBrand().getName());
        brand.setCategory(product.getBrand().getCategory());

        System.out.println(brand.getCategory() + " " + brand.getName());
        brandRepository.save(brand);
        sysProductrepo.save(product);
        return "redirect:/show-all-product";
    }
    
    
    @RequestMapping("/show-all-product")
    public String showAllProducts(Model model)
    {
    	Iterable<SystemProduct> pro=sysProductrepo.findAll();
    	List<Product> products=new ArrayList<Product>();
    	for(Product p:pro)
    	{
    		products.add(p);
    	}
    	model.addAttribute("products",products);
    	return "show-all-product";
    }
}
