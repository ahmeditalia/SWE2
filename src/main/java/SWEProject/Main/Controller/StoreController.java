package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.BrandRepository;
import SWEProject.Main.Controller.Repository.StoreProductRepository;

import SWEProject.Main.Controller.Repository.StoreRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Controller
public class StoreController {
	@Autowired
	private StoreRepository repo;
	@Autowired
	private StoreProductRepository prepo;
	@Autowired
	private SystemProductRepository sprepo;
	@Autowired
	private BrandRepository brepo;

	
	@RequestMapping("/statistics")
	@ResponseBody
	public Statistics showstat() {
		// example
		Random rand = new Random();
		int n = rand.nextInt(250);
		int m = rand.nextInt(n);
		Statistics statistics = new Statistics(n, m, rand.nextInt(m));
		return statistics;
	}

	@RequestMapping("/add-product-store")
	public void addProduct(@RequestParam String p, @RequestParam String sname) {
		Store s = repo.findOne(sname);
		StoreProduct product = prepo.findByname(p);
		s.addProduct(product);
		repo.save(s);
		prepo.save(product);
	}

}
