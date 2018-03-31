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
import org.springframework.web.bind.annotation.RequestBody;
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
	private BrandRepository brandRepository;

	@GetMapping("/add-product-to-system")
	public String showProductForm(Model model) {
		model.addAttribute("product", new SystemProduct());
		return "add-product-to-system";
	}

	@PostMapping("/add-product-to-system")
	@ResponseBody
	public void addProduct(@RequestBody SystemProduct product) {
		if(!sysProductrepo.existsByName(product.getName())) {
			Brand productBrand = brandRepository.findBrandByName(product.getBrand().getName());
			product.setBrand(productBrand);
			sysProductrepo.save(product);
		}
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
	@ResponseBody
	public List<Product>  showAllProducts() {
		Iterable<SystemProduct> pro = sysProductrepo.findAll();
		List<Product> products = new ArrayList<Product>();
		for (Product p : pro) {
			products.add(p);
		}
		return products;
	}
	
	@RequestMapping("/productsOfBrand")
	@ResponseBody
	public  List<SystemProduct> productsOfBrand(@RequestBody String bname) {
		List<SystemProduct> products = new ArrayList<SystemProduct>();
		Brand b = brandRepository.findBrandByName(bname);
		for (int i = 0; i < b.getProducts().size(); i++)
			products.add((SystemProduct) b.getProducts().get(i));
		return products;
	}

	@RequestMapping("/allSystemProduct")
	@ResponseBody
	public List<SystemProduct> allSystemProduct() {
		Iterable<SystemProduct> Products;
		List<SystemProduct> products = new ArrayList<SystemProduct>();
		Products = sysProductrepo.findAll();
		for (SystemProduct p : Products) {
			products.add(p);
		}
		return products;
	}

}
