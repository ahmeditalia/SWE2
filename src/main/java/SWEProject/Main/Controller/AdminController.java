package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		List<Store> stores = storeRepo.findByStatus("Onhold");
		model.addAttribute("stores", stores);
		return "view-request-stores";
	}
	
	@RequestMapping("/accept")
	public String accept(@RequestParam("storename") String storeName)
	{
		Store store=storeRepo.findOne(storeName);
		store.setStatus("accepted");
		storeRepo.save(store);
		return "redirect:/view-request-stores";
	}

	@RequestMapping("/reject")
	public String reject(@RequestParam("storename") String storeName)
	{
		storeRepo.delete(storeName);
		return "redirect:/view-request-stores";
	}
	@GetMapping("/admin-view")
	public String loadView(Model model) {
		int Count=storeRepo.countOnHold();
		model.addAttribute("N", Count);
		return "admin-view";
	}

}
