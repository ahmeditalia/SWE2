package SWEProject.Main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {
	

	@GetMapping("/view-request-stores")
	public String Viewrequests(Model model)
	{
		List<Store> stores = new ArrayList<Store>();
		Store store;
		StoreOwner storeOwner;
		for(int i=1;i<10;i++) {
			storeOwner=new StoreOwner("A"+i, "B"+i, "asdfasdf"+i);
			store=new Store("S"+i,storeOwner) {
			}; 
			stores.add(store);
		}
		model.addAttribute("stores",stores);
		return "view-request-stores";
	}
	
	
	@GetMapping("/admin-view")
	public String loadView(Model model)
	{
		model.addAttribute("N",0);
		return "admin-view";
	}
	

}
