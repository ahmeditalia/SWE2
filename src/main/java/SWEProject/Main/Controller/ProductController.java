package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.Product;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Entities.SystemProduct;
import SWEProject.Main.Controller.Repository.BrandRepository;
import SWEProject.Main.Controller.Repository.StoreProductRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.Response;

@Controller
public class ProductController {
	@Autowired
	private SystemProductRepository sysProductrepo;
	@Autowired
	private StoreProductRepository storeProductRepo;
	@Autowired
	private BrandRepository brandRepository;

	@GetMapping("/add-product-to-system")
	public String showProductForm(Model model) {
		model.addAttribute("product", new SystemProduct());
		return "add-product-to-system";
	}

	@PostMapping("/add-product-to-system")
	public String addProduct(@ModelAttribute SystemProduct product) {
		Brand brand = new Brand();
		brand.setName(product.getBrand().getName());
		brand.setCategory(product.getBrand().getCategory());
		brandRepository.save(brand);
		product.setBrand(brand);
		sysProductrepo.save(product);
		return "redirect:/show-all-product";
	}

	/*test fnction*/
	@RequestMapping("/products")
	public @ResponseBody List<Product> products() {
		StoreProduct storeProduct;
		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			storeProduct = new StoreProduct();
			storeProduct.setBrand(new Brand("" + i, "" + i * 2));	
			storeProduct.setId(i);
			storeProduct.setName("" + i);
			storeProduct.setQuantity(i * i);
			storeProduct.setType(" Store Type ");
			storeProduct.setStore(new Store("S" + i, new StoreOwner("a", "b", "c"), "location", "type", "state"));
			products.add(storeProduct);
		}
		return products;
	}

	@RequestMapping("/show-all-product")
	public String showAllProducts(Model model) {
		Iterable<SystemProduct> pro = sysProductrepo.findAll();
		List<Product> products = new ArrayList<Product>();
		for (Product p : pro) {
			products.add(p);
		}
		model.addAttribute("products", products);
		return "show-all-product";
	}
}
