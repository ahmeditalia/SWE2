package SWEProject.Main.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import SWEProject.Main.Controller.Entities.Creator;
import SWEProject.Main.Controller.Entities.OnlineStore;
import SWEProject.Main.Controller.Entities.Product;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.SystemProduct;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.StoreOwnerRepository;
import SWEProject.Main.Controller.Repository.StoreRepository;

@Controller
public class StoreOwnerController {

	@Autowired
	StoreRepository storeRepo;
	@Autowired
	StoreOwnerRepository ownerRepo;
	@GetMapping("/store-owner-view")
	public String showStoreOwnerView(Model model) {
		StoreOwner user = (StoreOwner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Store> stores=storeRepo.findByStoreOwnerAndStatus(user, "accepted");
		model.addAttribute("stores", stores);
		return "store-owner-view";
	}

	/*
	 * @GetMapping("/add-store") public String creationStoreView(Model model) {
	 * 
	 * return "add-store"; }
	 */
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

	/*test function*/
	@GetMapping("/add-product-to-store")
	public String addproduct() {
		
		return "add-product-to-store";
	}
	
	@GetMapping("/store-view")
	public List<Store> StoreOwnerStores() {
		
		List<Store> stores = storeRepo.findByStatus("accepted");
		return stores;
	}
}
