package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.*;
import SWEProject.Main.Controller.Repository.BrandRepository;
import SWEProject.Main.Controller.Repository.StoreProductRepository;

import SWEProject.Main.Controller.Repository.StoreRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StoreController {
    @Autowired
    private StoreRepository repo;
    private StoreProductRepository prepo;
    private SystemProductRepository sprepo;
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
        Products=sprepo.findByBrand(bname);
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
        Brands = brepo.findByProducts(pname);
        for (Brand p : Brands) {
            brands.add(p);
        }
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


    @RequestMapping("/show-all-product-store")
    public String showAllProducts(Model model,  @PathVariable String oname, @PathVariable String sname)
    {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager em = emfactory.createEntityManager();

        List AllProducts= em.createQuery("SELECT a FROM StoreProduct a", StoreProduct.class).getResultList();
        List<StoreProduct> allProducts=AllProducts;

        List<StoreProduct> products=new ArrayList<StoreProduct>();
        for(StoreProduct p:allProducts)
        {
            if(p.getStore().getStoreName().equals(sname)){
                products.add(p);
            }
        }
        model.addAttribute("products",products);
        return "show-products-on-store";
    }
}
