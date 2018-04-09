package SWEProject.Main.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import SWEProject.Main.Controller.Entities.Statistics;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Repository.StatisticsRepository;
import SWEProject.Main.Controller.Repository.StoreRepository;
import java.util.List;
@Controller
public class AdminController {
	@Autowired
	StoreRepository storeRepo;
	@Autowired
	StatisticsRepository statRepo;
	
	@RequestMapping("/view-request-stores")
	@ResponseBody
	public List<Store> Viewrequests() {
		List<Store> stores = storeRepo.findByStatus("Onhold");
		return stores;
	}
	@PostMapping("/accept")
	@ResponseBody
	public void accept(@RequestParam("storename") String storeName)
	{
		Store store=storeRepo.findOne(storeName);
		store.setStatus("accepted");
		Statistics statistics=new Statistics(store);
		statRepo.save(statistics);
		storeRepo.save(store);
	}
	@PostMapping("/reject")
	@ResponseBody
	public void reject(@RequestParam("storename") String storeName)
	{
		storeRepo.delete(storeName);
	}
	@GetMapping("/admin-view")
	public String loadView() {
		return "admin-view";
	}
	@PostMapping("/requestNumber")
	@ResponseBody
	public int requestNumber()
	{
		return storeRepo.countOnHold();
	}
}
