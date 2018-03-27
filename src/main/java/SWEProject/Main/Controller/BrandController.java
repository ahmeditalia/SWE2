package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
	public String addBrand(@RequestParam String brandname,@RequestParam String brandcategory) {

		if(!repo.existsByName(brandname)) {
			Brand brand = new Brand();
			brand.setCategory(brandcategory);
			brand.setName(brandname);
			repo.save(brand);
		}
		return "redirect:/admin-view";
	}

	@RequestMapping("/brands")
	public @ResponseBody List<Brand> brands() {

		Iterable<Brand> allBrands = repo.findAll();
		List<Brand> brands = new ArrayList<Brand>();

		for (Brand b : allBrands) {
			brands.add(b);
		}
		return brands;
	}
}
