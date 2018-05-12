package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.SystemProduct;
import SWEProject.Main.Controller.Repository.BrandRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BrandController {
	
	private BrandRepository brandRepo;
	private SystemProductRepository systemProductRepo;

	@Autowired
	public BrandController(BrandRepository brandRepo, SystemProductRepository systemProductRepo) {
		this.brandRepo = brandRepo;
		this.systemProductRepo = systemProductRepo;
	}

	@PostMapping("/add-brand")
	@ResponseBody
	public boolean addBrand(@RequestBody Brand brand) {
		if (!brandRepo.existsByName(brand.getName())) {
			brandRepo.save(brand);
			return true;
		}
		return false;
	}

	@RequestMapping("/brands")
	@ResponseBody
	public List<Brand> brands() {
		Iterable<Brand> allBrands = brandRepo.findAll();
		List<Brand> brands = new ArrayList<Brand>();

		for (Brand b : allBrands) {
			brands.add(b);
		}
		return brands;
	}

	@RequestMapping("/brandOfProduct")
	public @ResponseBody Brand brands(@RequestParam("pname") String pname) {
		SystemProduct s = systemProductRepo.findOneByName(pname);
		Brand b = s.getBrand();
		return b;
	}
}