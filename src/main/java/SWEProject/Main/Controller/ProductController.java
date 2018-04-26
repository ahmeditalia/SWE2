package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	@Autowired
	private CartRepository cartRepo;

	@PostMapping("/add-product-to-system")
	@ResponseBody
	public boolean addProduct(@RequestBody SystemProduct product) {
		if (!sysProductrepo.existsByName(product.getName())) {
			Brand productBrand = brandRepository.findBrandByName(product.getBrand().getName());
			product.setBrand(productBrand);
			sysProductrepo.save(product);
			return true;
		}
		return false;
	}

	@RequestMapping("/allSystemProduct")
	@ResponseBody
	public List<Product> allSystemProduct() {
		Iterable<SystemProduct> Products = sysProductrepo.findAll();
		List<Product> products = new ArrayList<Product>();
		for (Product p : Products) {
			products.add(p);
		}
		return products;
	}

	@RequestMapping("/Store-products")
	public @ResponseBody List<StoreProduct> StoreProducts(@RequestBody List<String> sList) {
		List<StoreProduct> products = new ArrayList<StoreProduct>();
		for (String sname : sList) {
			products.addAll(storeProductRepo.findByStore_StoreNameAndExist(sname, "exist"));
		}
		return products;
	}

	@RequestMapping("/allStoreProducts")
	public @ResponseBody Iterable<StoreProduct> products() {
		return storeProductRepo.findAll();
	}

	@RequestMapping("/productsOfBrand")
	@ResponseBody
	public List<SystemProduct> productsOfBrand(@RequestBody String bname) {
		return sysProductrepo.findByBrand_Name(bname);
	}

	@RequestMapping("/ShowAllProductsByName")
	@ResponseBody
	public List<StoreProduct> ShowAllProductsByName(@RequestBody String spname) {
		if (spname.equals("all")) {
			return (List<StoreProduct>) storeProductRepo.findAllByExist("exist");
		}
		return storeProductRepo.findByNameAndExist(spname, "exist");
	}

	@RequestMapping("/ShowProductByName/{spname}")
	@ResponseBody
	public SystemProduct ShowProductByName(@PathVariable("spname") String spname) {
		SystemProduct systemProduct = sysProductrepo.findOneByName(spname);
		return systemProduct;
	}

	@RequestMapping("/buyProduct")
	@ResponseBody
	public double buyProduct(@RequestBody List<StoreProduct> storeProducts) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Cart cart = cartRepo.findOneByUser_username(user.getUsername());
		double price = 0;
		for (int i = 0; i < storeProducts.size(); i++) {
			Store store = storeProducts.get(i).getStore();
			if (storeProducts.get(i).getQuantity() >= 2) {
				user.addDiscount(PlusTwoItems.class);
			}
			price += (storeProducts.get(i).getPrice() * user.getDiscount().getDis());
			user.deleteDiscount(FirstBuyDiscount.class);
			user.deleteDiscount(PlusTwoItems.class);
			// user.decreaseBalance(storeProducts.get(i).getPrice());
			StoreProduct storeProduct=storeProductRepo.findByNameAndStore_storeName(storeProducts.get(i).getName(),storeProducts.get(i).getStore().getStoreName());
			storeProductRepo.updateQuantity(storeProducts.get(i).getQuantity(), store.getStoreName(), storeProduct.getId());
			// userRepo.updateBalance(storeProducts.get(i).getPrice(), user.getUsername());
			statRepo.updateNumUserBuy(store.getStoreName());
			statRepo.updateNumUserView(store.getStoreName());
			statRepo.updateSoldProducts(store.getStoreName(),storeProducts.get(i).getQuantity());
			userRepo.save(user);/* if save->update */
		}
		return price;
	}
}
