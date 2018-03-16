package SWEProject.Main.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SWEProject.Main.Controller.Entities.Creator;
import SWEProject.Main.Controller.Entities.OnlineStore;
import SWEProject.Main.Controller.Entities.Product;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.SystemProduct;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.StoreRepository;

@Controller
public class StoreOwnerController {

	@Autowired
	StoreRepository storeRepo;

	@GetMapping("/store-owner-view")
	public String showStoreOwnerView(Model model) {
		model.addAttribute("store", new Store());
		return "store-owner-view";
	}

	/*
	 * @GetMapping("/add-store") public String creationStoreView(Model model) {
	 * 
	 * return "add-store"; }
	 */
	@PostMapping("/add-store")
	public String newStore(@ModelAttribute Store store, @RequestParam("type2") String type) {
		if (!storeRepo.exists(store.getStoreName())) {
			StoreOwner storeOwner = new StoreOwner(
					(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			store = Creator.getInstance().createStore(type, store, storeOwner);
			storeOwner.addStore(store);
			storeRepo.save(store);
			return "redirect:/store-owner-view";
		}
		return "redirect:/store-owner-view?error";
	}

	@GetMapping("/store-view")
	public String StoreOwnerStores(Model model) {
		
		List<Store> stores = storeRepo.findByStatus("accepted");
		model.addAttribute("stores", stores);
		return "store-view";
	}
}
