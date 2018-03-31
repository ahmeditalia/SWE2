package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NormalUserController {
    @Autowired
    private StoreProductRepository sprepo;
    @RequestMapping("/ShowAllProductsByName")
    @ResponseBody
    public  List<StoreProduct> ShowAllProductsByName(@RequestBody String spname) {
        List<StoreProduct> str = sprepo.findByName(spname);
        return str;
    }

}
