package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Collaborator;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CollaboratorController {

    
    private CollaboratorRepository collabRepo;
    @Autowired
    public CollaboratorController(CollaboratorRepository collabRepo) {
		this.collabRepo = collabRepo;
	}
	@RequestMapping("/view-store-collaborator")
    @ResponseBody
    public List<Store> getCollabStores(){

        Collaborator user = (Collaborator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  collabRepo.findByStoreOwner(user.getStoreOwner());
    }
    @RequestMapping("/collaborator")
    public String coll(){
        return "collaborator";
    }
}

