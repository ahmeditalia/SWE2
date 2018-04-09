package SWEProject.Main.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Repository.StoreRepository;
@Controller
public class StoreOwnerController {
	@Autowired
	StoreRepository storeRepo;
	@GetMapping("/store-owner-view")
	public String showStoreOwnerView() {
		return "store-owner-view";
	}
	/*
	 * @GetMapping("/add-store") public String creationStoreView(Model model) {
	 * 
	 * return "add-store"; }
	 */

	/*test function*/
}