package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Repository.StoreRepository;

@Controller
public class StoreOwnerController {

	@Autowired
	StoreRepository storeRepo;
	
	@GetMapping("/store-owner-view")
	public String showStoreOwnerView()
	{
		return "store-owner-view";
	}
	@GetMapping("/add-store")
	public String creationStoreView(Model model)
	{
		model.addAttribute("store",new String());
		return "add-store";
	}
	@PostMapping("/add-store")
	public String newStore(@ModelAttribute Store store ,@RequestParam("type") String type)
	{
		if(!storeRepo.exists(store.getStoreName()))
		{
			StoreOwner storeOwner=(StoreOwner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			storeOwner.addStore(store,type);
			storeRepo.save(store);
			return "redirect:/store-owner-view";
		}
		return "redirect:/add-store?error";
	}
}
