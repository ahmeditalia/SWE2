package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Collaborator;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CollaboratorController {

    @Autowired
    private CollaboratorRepository collabRepo;

    @RequestMapping("collaborator-view")
    public List<Store> getCollabStores(){

        Collaborator user = (Collaborator) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  collabRepo.findByStoreOwner(user.getStoreOwner());
    }
}

