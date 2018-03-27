package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrandController {

	@Autowired
	private BrandRepository repo;

	// @GetMapping("/add-brand")
	// public String addBrand(Model model){
	// model.addAttribute("brand",new Brand());
	// return "add-brand";
	// }

	@RequestMapping("/add-brand")
	public String addBrand(@RequestParam String name,@RequestParam String category) {
		Brand brand = new Brand();
		brand.setCategory(category);
		brand.setName(name);
		repo.save(brand);
		return "redirect:/admin-view";
	}
}
