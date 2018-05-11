package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class StoreController {
    @Autowired
    public StoreRepository storeRepo;
    @Autowired
    public StoreProductRepository storeProductRepo;
    @Autowired
    public StatisticsRepository statRepo;


    @RequestMapping("/ShowOwnerStores")
    @ResponseBody
    public List<Store> showAllStores() {
        StoreOwner user = (StoreOwner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return storeRepo.findByStoreOwnerAndStatus(user, "accepted");
    }

    @RequestMapping("/openStore")
    @ResponseBody
    public List<StoreProduct> openStore(@RequestBody String sname) {
        List<StoreProduct> sProducts = new ArrayList<StoreProduct>();
        Store s = storeRepo.findOneByStoreName(sname);
        for (int i = 0; i < s.getProducts().size(); i++) {
            sProducts.add(s.getProducts().get(i));
        }
        statRepo.updateNumUserView(sname);
        return sProducts;
    }

    @PostMapping("/add-store")
    @ResponseBody
    public boolean newStore(@RequestBody Store store, @RequestParam("type") String type) {
        if (!storeRepo.exists(store.getStoreName())) {
            StoreOwner storeOwner = new StoreOwner(
                    (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
            store = Creator.getInstance().createStore(type, store, storeOwner);
            storeOwner.addStore(store);
            storeRepo.save(store);
            return true;
        }
        return false;
    }
    
    @RequestMapping("/store-commands")
    @ResponseBody
    public List<Command> getStoreCommands() {

        StoreOwner user = (StoreOwner) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Command> commands=storeRepo.findByStoreOwner(user);
        return  commands;
    }
}
