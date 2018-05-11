package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
		Creator creator=Creator.getInstance();
		StoreOwner storeOwner = (StoreOwner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!userRepository.exists(collaborator.getUsername()))
		{
			Collaborator user=(Collaborator) creator.createUser("collaborator", collaborator);
			user.setStoreOwner(storeOwner);
			userRepository.save(user);
			return true;
		}
		else {
			return false;
		}
	}
}