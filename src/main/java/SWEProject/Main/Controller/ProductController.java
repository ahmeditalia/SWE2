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
	private UserRepository userRepo;
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private DiscountRepository discountRepository;
	@Autowired
	private TransactionRepository transRepo;
	@Autowired
	private CommandRepository commandRepo;
	@Autowired
	private SoldProductRepository soldProdRepo;

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
	public Iterable<SystemProduct> allSystemProduct() {
		return sysProductrepo.findAll();
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
			return storeProductRepo.findAllByExist("exist");
		}
		else if(storeProductRepo.existsByNameAndExist(spname, "exist")) {
			return storeProductRepo.findByNameAndExist(spname, "exist");
		}
		else
			return new ArrayList<StoreProduct>();
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
		int deletedItemID;
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user=userRepo.findOne(user.getUsername());
		Cart cart = cartRepo.findOneByUser_username(user.getUsername());
		double price = 0;
		for (int i = 0; i < storeProducts.size(); i++) {
			Store store =storeRepo.findOneByStoreName(storeProducts.get(i).getStore().getStoreName());
			if (storeProducts.get(i).getQuantity() >= 2) {
				user.addDiscount(new PlusTwoItems());
			}
			price += (storeProducts.get(i).getPrice() * ((100-user.getDiscount().getDis())/100));
			user.deleteDiscount(PlusTwoItems.class);
			StoreProduct storeProduct=storeProductRepo.findByNameAndStore_storeName(storeProducts.get(i).getName(),storeProducts.get(i).getStore().getStoreName());
			if(storeProduct.getQuantity()==storeProducts.get(i).getQuantity())
			{
				commandRepo.deleteByProduct_Id(storeProduct.getId());
			}
			else {
				storeProduct.setQuantity(storeProduct.getQuantity()-storeProducts.get(i).getQuantity());
				storeRepo.save(store);
				cart.removeProduct(storeProduct);
				storeProduct.removeCart(cart);
				storeProductRepo.save(storeProduct);
			}
			UpdateStatistics(store,storeProducts.get(i).getQuantity());
			SoldProduct soldProduct=new SoldProduct(storeProduct,storeProducts.get(i).getQuantity(),storeProducts.get(i).getPrice(), price);
			Transactions transactions=new Transactions(user, store, soldProduct);
			soldProdRepo.save(soldProduct);
			transRepo.save(transactions);
		}
		deletedItemID=user.deleteDiscount(FirstBuyDiscount.class);
		cartRepo.save(cart);
		userRepo.save(user);
		if(deletedItemID!=-1)
		{
			discountRepository.delete(deletedItemID);
		}
		return price;
	}
	
	public void UpdateStatistics(Store store,int quantity)
	{
		store.getStatistics().increamentSoldProducts(quantity);
		store.getStatistics().increamentUserBuy();
		store.getStatistics().increamentUserViews();
	}
}
