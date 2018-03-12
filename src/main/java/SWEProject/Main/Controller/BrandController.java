package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BrandController {

    @Autowired
    private BrandRepository repo;

    @GetMapping("/add-brand")
    public String addBrand(Model model){
        model.addAttribute("brand",new Brand());
        return "add-brand";
    }

    @PostMapping("/add-brand")
    public String addBrand(@ModelAttribute Brand brand){
        repo.save(brand);
        return "redirect:/admin-view";
    }
}
