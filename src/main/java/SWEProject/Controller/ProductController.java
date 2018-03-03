package SWEProject.Controller;
import SWEProject.Entities.Product;
import SWEProject.Repository.ProductRepository;
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
    @GetMapping("/addProduct")
    public String showproductsform(Model model){
        model.addAttribute("Product",new Product());
        return "addproduct";
    }
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product){
        repo.save(product);
        return "show-all-products";
    }
}
