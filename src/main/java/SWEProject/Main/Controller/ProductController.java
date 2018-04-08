package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mysql.fabric.Response;
@Controller
public class ProductController {
	@Autowired
	private SystemProductRepository sysProductrepo;
	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private StoreProductRepository storeProductRepo;
	@Autowired
	private StoreRepository storeRepo;
	@Autowired
	private StatisticsRepository statRepo;
	@Autowired
	private UserRepository userRepo;

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
	/*@RequestMapping("/products")
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
	}*/
	
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
	public List<Product> allSystemProduct() {
		Iterable<SystemProduct> Products= sysProductrepo.findAll();
		List<Product> products = new ArrayList<Product>();
		for (Product p : Products) {
			products.add(p);
		}
		return products;
	}
	@RequestMapping("/ShowAllProductsByName")
	@ResponseBody
	public  List<StoreProduct> ShowAllProductsByName(@RequestBody String spname) {
		List<StoreProduct> str = storeProductRepo.findByName(spname);
		return str;
	}
	@RequestMapping("/ShowProductByName")
	@ResponseBody
	public  SystemProduct ShowProductByName(@RequestBody String spname) {
		SystemProduct systemProduct = sysProductrepo.findOneByName(spname);
		return systemProduct;
	}
	@RequestMapping("/add-product-store/{storeName}")
	@ResponseBody
	public void addProduct(@RequestBody() StoreProduct p,@PathVariable("storeName")String sname) {
		boolean x=true;
		Store s = storeRepo.findOneByStoreName(sname);
		for(int i=0;i<s.getProducts().size();i++){
			if(s.getProducts().get(i).getName().equals(p.getName())){
				x=false;
				break;
			}
		}
		if(x==true) {
			SystemProduct product = sysProductrepo.findOneByName(p.getName());
			StoreProduct storeProduct = new StoreProduct(p.getQuantity(), p.getPrice(), s);
			storeProduct.setName(product.getName());
			storeProduct.setBrand(product.getBrand());
			storeProduct.setType(product.getType());
			s.addProduct(storeProduct);
			storeProductRepo.save(storeProduct);
		}
	}
	@GetMapping("/add-product-to-store")
	public String addproduct() {
		return "add-product-to-store";
	}
	@RequestMapping("/buyProduct")
	@ResponseBody
	public  boolean buyProduct(@RequestBody String all) {
		String[] parts = all.split("-");
		String spname = parts[0];
		String normaluserName = parts[1];
		String storeName = parts[2];
		int quantity = Integer.parseInt(parts[3]);
		User user=userRepo.findOneByUsername(normaluserName);
		StoreProduct storeProduct=storeProductRepo.findByNameAndStore(spname,storeName);
		Store store=storeRepo.findOneByStoreName(storeName);
		Discount d=new Discount();
		if(quantity>=2){
			PlusTwoItems t=new PlusTwoItems(d);
		}
		FirstBuyDiscount f=new FirstBuyDiscount(d);
		StoreOwnerDiscount s=new StoreOwnerDiscount(f);

		if(user.getBalance()>storeProduct.getPrice()||storeProduct.getQuantity()-quantity<0){
			return false;
		}

		user.decreaseBalance(storeProduct.getPrice());
		storeProductRepo.updateQuantity(quantity,storeName,storeProduct.getId());
		userRepo.updateBalance(storeProduct.getPrice(),user.getUsername());
		statRepo.updateNumUserBuy(storeName);
		statRepo.updateNumUserView(storeName);
		statRepo.updateSoldProducts(storeName,quantity);
		return true;
	}

}
