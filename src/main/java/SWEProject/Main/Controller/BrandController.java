package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.SystemProduct;
import SWEProject.Main.Controller.Repository.BrandRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;

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
    @Autowired
    private SystemProductRepository sprepo;

	// @GetMapping("/add-brand")
	// public String addBrand(Model model){
	// model.addAttribute("brand",new Brand());
	// return "add-brand";
	// }

	@PostMapping("/add-brand")
	@ResponseBody
	public void addBrand(@RequestBody Brand brand) {
		if(!repo.existsByName(brand.getName())) {
			repo.save(brand);
		}
	}

	@RequestMapping("/brands")
	@ResponseBody
	public List<Brand> brands() {

		Iterable<Brand> allBrands = repo.findAll();
		List<Brand> brands = new ArrayList<Brand>();

		for (Brand b : allBrands) {
			brands.add(b);
		}
		return brands;
	}
	
    @RequestMapping("/brandOfProduct")
    public @ResponseBody Brand brands(@RequestParam("pname") String pname) {
        SystemProduct s=sprepo.findOneByName(pname);
        Brand b=s.getBrand();
        return b;
    }
}
