package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
	@Autowired
	StoreRepository storeRepo;

	@RequestMapping("/view-request-stores")
	@ResponseBody
	public List<Store> Viewrequests() {
		List<Store> stores = storeRepo.findByStatus("Onhold");
		return stores;
	}
	
	@RequestMapping("/accept")
	@ResponseBody
	public void accept(@RequestBody String storeName)
	{
		Store store=storeRepo.findOne(storeName);
		store.setStatus("accepted");
		storeRepo.save(store);
	}

	@RequestMapping("/reject")
	public void reject(@RequestBody String storeName)
	{
		storeRepo.delete(storeName);
	}
	@GetMapping("/admin-view")
	public String loadView(Model model) {
		int Count=storeRepo.countOnHold();
		model.addAttribute("N", Count);
		return "admin-view";
	}

}
