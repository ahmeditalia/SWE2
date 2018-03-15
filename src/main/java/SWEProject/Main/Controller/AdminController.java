package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
	@Autowired
	StoreRepository storeRepo;

	@GetMapping("/view-request-stores")
	public String Viewrequests(Model model) {
		Iterable<Store> sto = storeRepo.findAll();
		List<Store> stores = new ArrayList<Store>();
		for (Store p : sto) {
			if (p.getStatus().equals("Onhold"))
				stores.add(p);
		}
		model.addAttribute("stores", stores);
		return "view-request-stores";
	}
	
	@PostMapping("/accept")
	public String accept(@RequestParam("storename") String type)
	{
		
		return "rediredt:/view-request-stores";
	}

	@PostMapping("/reject")
	public String reject(@RequestParam("storename") String type)
	{
		
		return "rediredt:/view-request-stores";
	}
	@GetMapping("/admin-view")
	public String loadView(Model model) {
		model.addAttribute("N", 0);
		return "admin-view";
	}

}
