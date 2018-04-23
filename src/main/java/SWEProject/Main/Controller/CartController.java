package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.Cart;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.CartRepository;
import SWEProject.Main.Controller.Repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    StoreProductRepository storeProductRepository;
    @Autowired
    CartRepository cartRepository;

    @RequestMapping("/addtocart")
    @ResponseBody
    public void addToCart(@RequestParam("spname") String spname) {
        String[] parts = spname.split("-");
        String storeProductName = parts[0];
        String storeName = parts[1];
        StoreProduct storeProduct=storeProductRepository.findByNameAndStore_storeName(storeProductName,storeName);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cart cart=cartRepository.findOneByUser_username(user.getUsername());
        cart.addProduct(storeProduct);
        storeProduct.addCart(cart);
        storeProductRepository.save(storeProduct);
    }
    @RequestMapping("/removefromcart")
    @ResponseBody
    public void removeFromCart(@RequestParam("spname") String spname) {
        String[] parts = spname.split("-");
        String storeProductName = parts[0];
        String storeName = parts[1];
        StoreProduct storeProduct=storeProductRepository.findByNameAndStore_storeName(storeProductName,storeName);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cart cart=cartRepository.findOneByUser_username(user.getUsername());
        cart.removeProduct(storeProduct);
        storeProduct.removeCart(cart);
        storeProductRepository.save(storeProduct);
    }
    @RequestMapping("/viewProductsCart")
    @ResponseBody
    public void viewProductsCart() {
        /*User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Cart cart=cartRepository.findOneByUser_username(user.getUsername());
        List<StoreProduct> storeProducts=cartRepository.findByCart(cart);
        /*for(int i=0;i<storeProducts.size();i++)
            System.out.print(storeProducts.get(i).getName()+"  ");*/
    }

}