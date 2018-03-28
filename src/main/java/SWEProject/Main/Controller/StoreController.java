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

    @RequestMapping("/productstore")
    public @ResponseBody List<SystemProduct> products(@RequestParam ("bname")String bname) {
        Iterable<SystemProduct> Products ;
        List<SystemProduct> products = new ArrayList<SystemProduct>();
        if(bname.equals("")) {
            Products=sprepo.findAll();
            for (SystemProduct p : Products) {
                products.add(p);
            }
            return products;
        }
        Brand b=brepo.findBrandByName(bname);
        for(int i=0;i<b.getProducts().size();i++)
        products.add((SystemProduct)b.getProducts().get(i));
        return products;

    }

    @RequestMapping("/Allbrandstore")
    public @ResponseBody List<Brand> brands() {
        Iterable<Brand> Brands ;
        List<Brand> brands = new ArrayList<Brand>();
            Brands = brepo.findAll();
            for (Brand p : Brands) {
                brands.add(p);
            }
            return brands;
    }
    @RequestMapping("/Allproductstore")
    public @ResponseBody List<SystemProduct> products() {
        Iterable<SystemProduct> Products ;
        List<SystemProduct> products = new ArrayList<SystemProduct>();
            Products=sprepo.findAll();
            for (SystemProduct p : Products) {
                products.add(p);
            }
            return products;
    }

    @RequestMapping("/brandstore")
    public @ResponseBody List<Brand> brands(@RequestParam("pname") String pname) {
        Iterable<Brand> Brands ;
        List<Brand> brands = new ArrayList<Brand>();
        if(pname.equals("")) {
            Brands = brepo.findAll();
            for (Brand p : Brands) {
                brands.add(p);
            }
            return brands;
        }
        SystemProduct s=sprepo.findOneByName(pname);
        Brand b=s.getBrand();
        brands.add(b);
        return brands;
    }

    @RequestMapping("/statistics")
    @ResponseBody
    public Statistics showstat()
    {
    	//example
    	Random rand = new Random();
    	int  n = rand.nextInt(250);
    	int m=rand.nextInt(n);
    	Statistics statistics=new Statistics(n, m, rand.nextInt(m));
    	return statistics;
    }
    

    @RequestMapping("/add-product-store")
    public void addProduct(@RequestParam String p, @RequestParam String sname){
        Store s=repo.findOne(sname);
        StoreProduct product=prepo.findByname(p);
        s.addProduct(product);
        repo.save(s);
        prepo.save(product);
    }


}
