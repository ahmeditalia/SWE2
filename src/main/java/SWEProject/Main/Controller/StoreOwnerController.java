package SWEProject.Main.Controller;
import java.util.List;

import SWEProject.Main.Controller.Entities.Collaborator;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.CollaboratorRepository;
import SWEProject.Main.Controller.Repository.UserRepository;
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
	@Autowired
	UserRepository userRepository;

	@GetMapping("/store-owner-view")
	public String showStoreOwnerView() {
		return "store-owner-view";
	}

	@RequestMapping("/add-collaborator")
	@ResponseBody
	public boolean addCollaborator(@RequestBody User collaborator){

		StoreOwner storeOwner = new StoreOwner(
				(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		if(!userRepository.exists(collaborator.getUsername()))
		{
			collaborator = new Collaborator(collaborator, storeOwner);
			userRepository.save(collaborator);
			return true;
		}
		else {
			return false;
		}
	}
	/*
	 * @GetMapping("/add-store") public String creationStoreView(Model model) {
	 * 
	 * return "add-store"; }
	 */

	/*test function*/
}