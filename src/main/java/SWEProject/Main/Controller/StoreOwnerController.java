package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import SWEProject.Main.Controller.Entities.OnlineStore;
import SWEProject.Main.Controller.Entities.OnsiteStore;
import SWEProject.Main.Controller.Entities.StoreIdentity;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.OnlineStoreRepository;
import SWEProject.Main.Controller.Repository.OnsiteStoreRepository;

@Controller
public class StoreOwnerController {

	@Autowired
	OnlineStoreRepository onlineStoreRepository;
	@Autowired
	OnsiteStoreRepository onsiteStoreRepository;
	
	@GetMapping("/store-owner-view")
	public String showStoreOwnerView()
	{
		return "store-owner-view";
	}
	@GetMapping("/add-store")
	public String creationStoreView(Model model)
	{
		return "add-store";
	}
	@PostMapping("/add-store")
	public String newStore()
	{
		
		return "";
	}
}
