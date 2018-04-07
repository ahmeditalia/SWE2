package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@Controller
public class StoreController {
	@Autowired
	private StoreRepository storeRepo;
	@Autowired
	private StoreProductRepository storeProductRepo;
	@Autowired
	private StatisticsRepository statRepo;
	@RequestMapping("/ShowAllStores")
	@ResponseBody
	public  List<Store> showAllStores(){
		Iterable<Store> str = storeRepo.findAll();
		List<Store> stores = new ArrayList<Store>();
		for (Store s : str) {
			stores.add(s);
		}
		return  stores;
	}
	@RequestMapping("/openStore")
	@ResponseBody
	public  List<StoreProduct> openStore(@RequestBody String sname){
		List<StoreProduct> sProducts = new ArrayList<StoreProduct>();
		Store s=storeRepo.findOneByStoreName(sname);
		for (int i=0;i<s.getProducts().size();i++) {
			sProducts.add(s.getProducts().get(i));
		}
		statRepo.updateNumUserView(sname);
		return  sProducts;
	}
	@PostMapping("/add-store")
	@ResponseBody
	public void newStore(@RequestBody Store store,@RequestParam("type") String type) {
		if (!storeRepo.exists(store.getStoreName())) {
			StoreOwner storeOwner = new StoreOwner(
					(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			store = Creator.getInstance().createStore(type, store, storeOwner);
			storeOwner.addStore(store);
			storeRepo.save(store);
		}
	}
	@GetMapping("/store-view")
	public List<Store> StoreOwnerStores() {

		List<Store> stores = storeRepo.findByStatus("accepted");
		return stores;
	}
}
