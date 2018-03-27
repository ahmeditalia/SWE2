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

public class StoreController {
    @Autowired
    private StoreRepository repo;
    private StoreProductRepository prepo;
    private SystemProductRepository sprepo;
    private BrandRepository brepo;
    @GetMapping("/{oname}/add-product-store")
    public String showproductsform(Model model, @PathVariable String oname){
        model.addAttribute("product",new StoreProduct());
        String url="/"+oname+"/add-product-store";
        return "add-product-to-store";
    }

    @RequestMapping("/productstore")
    public @ResponseBody List<SystemProduct> products(@RequestParam ("bname")String bname) {
        Iterable<SystemProduct> Products ;
        List<SystemProduct> products = new ArrayList<SystemProduct>();
        if(bname.equals("zero")) {
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
        if(pname.equals("zero")) {
            Brands = brepo.findAll();
            for (Brand p : Brands) {
                brands.add(p);
            }
            return brands;
        }
        Brands = brepo.findByProduct(pname);
        for (Brand p : Brands) {
            brands.add(p);
        }
        return brands;
    }


    @PostMapping("/{sname}/add-product-store")
    public String addProduct(@ModelAttribute StoreProduct product, @PathVariable String sname){
        Store s=repo.findOne(sname);
        s.addProduct(product);
        repo.save(s);
        prepo.save(product);
        String url = "redirect:/"+ sname + "/show-all-product-store";
        return url;
    }


    @RequestMapping("/{oname}/{sname}/show-all-product-store/")
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
