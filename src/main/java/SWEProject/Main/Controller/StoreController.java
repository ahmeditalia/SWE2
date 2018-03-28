package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.*;

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
	private StoreRepository sepo;
	@Autowired
	private StoreProductRepository prepo;
	@Autowired
	private SystemProductRepository sprepo;
	@Autowired
	private BrandRepository brepo;
	@Autowired
	private StoreOwnerRepository sorepo;
	@Autowired
	private StatisticsRepository statrepo;
	@Autowired
	private NormalUserRepository nurepo;

	
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
	public void addProduct(@RequestParam StoreProduct p, @RequestParam String sname) {
		Store s = sepo.findOneByStoreName(sname);
			s.addProduct(p);
			prepo.save(p);
			sepo.save(s);

	}
	@RequestMapping("/ShowAllStores")
	public @ResponseBody List<Store> showAllStores(){
		Iterable<Store> str = sepo.findAll();
		List<Store> stores = new ArrayList<Store>();
		for (Store s : str) {
			stores.add(s);
		}
		return  stores;
	}
	@RequestMapping("/openStore")
	public @ResponseBody List<StoreProduct> openStore( @RequestParam String sname){
		List<StoreProduct> sProducts = new ArrayList<StoreProduct>();
		Store s=sepo.findOneByStoreName(sname);
		for (int i=0;i<s.getProducts().size();i++) {
			sProducts.add(s.getProducts().get(i));
		}
		StoreOwner storeOwner=s.getStoreOwner();
		Statistics statistics=storeOwner.getStatistics();
		statistics.increamentUserViews();
		storeOwner.setStatistics(statistics);
		statrepo.save(statistics);
		sorepo.save(storeOwner);
		return  sProducts;
	}
	@RequestMapping("/buyProduct")
	public @ResponseBody boolean buyProduct(@RequestParam String spname,@RequestParam String normaluname,@RequestParam String storeName,@RequestParam int amounts) {
			NormalUser normalUser=nurepo.findOneByUserName(normaluname);
			StoreProduct storeProduct=prepo.findBynameAndStoreName(spname,storeName);
		Store store=sepo.findOneByStoreName(storeName);
			if(normalUser.getBalance()>storeProduct.getPrice()||storeProduct.getQuantity()-amounts<0){
				return false;
			}
		double balance=normalUser.getBalance()-storeProduct.getPrice();
		normalUser.setBalance(balance);
		nurepo.save(normalUser);
		storeProduct.setQuantity(storeProduct.getQuantity()-amounts);
		prepo.save(storeProduct);
		
		StoreOwner storeOwner=store.getStoreOwner();
		Statistics statistics=storeOwner.getStatistics();
		statistics.increamentUserBuy();
		statistics.increamentSoldProducts(amounts);
		storeOwner.setStatistics(statistics);
		statrepo.save(statistics);
		sorepo.save(storeOwner);
		return true;
		}
	}
