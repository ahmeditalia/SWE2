package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Product;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreIdentity;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Repository.OnlineStoreRepository;
import SWEProject.Main.Controller.Repository.StoreProductRepository;

import SWEProject.Main.Controller.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class StoreController {
    @Autowired
    private StoreRepository repo;
    private StoreProductRepository prepo;
    @GetMapping("/{oname}/{sname}/add-product-store")
    public String showproductsform(Model model, @PathVariable String oname, @PathVariable String sname){
        model.addAttribute("product",new StoreProduct());
        String url="/"+oname+"/"+sname+"/add-product-store";
        return url;
    }


    @PostMapping("/{oname}/{sname}/add-product-store")
    public String addProduct(@ModelAttribute StoreProduct product,@PathVariable String oname, @PathVariable String sname){
        StoreIdentity sID=new StoreIdentity(oname,sname);
        Store s=repo.findOne(sID);
        List<StoreProduct> products=s.getProducts();
        products.add(product);
        s.setProducts(products);
        //prepo.save(product);
        String url = "redirect:/" + oname + "/" + sname + "/show-all-product-store";
        return url;
    }


    @RequestMapping("/{oname}/{sname}/show-all-product-store/")
    public String showAllProducts(Model model,  @PathVariable String oname, @PathVariable String sname)
    {
        StoreIdentity sId=new StoreIdentity(oname,sname);
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
        EntityManager em = emfactory.createEntityManager();

        List AllProducts= em.createQuery("SELECT a FROM StoreProduct a", StoreProduct.class).getResultList();
        List<StoreProduct> allProducts=AllProducts;

        List<StoreProduct> products=new ArrayList<StoreProduct>();
        for(StoreProduct p:allProducts)
        {
            if(p.getStore().getStoreId().equals(sId)){
                products.add(p);
            }

        }
        model.addAttribute("products",products);
        return "show-all-product-store";
    }
}
