package SWEProject.Main.TestNG;

import SWEProject.Main.Application;
import SWEProject.Main.Controller.CollaboratorController;
import SWEProject.Main.Controller.Entities.Collaborator;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CollaboratorControllerTest extends AbstractTestNGSpringContextTests {

    private Collaborator user = new Collaborator();
    @Autowired
    private CollaboratorController controller;

    @BeforeTest
    public void setup() {

        user.setUsername("321");
        user.setEmail("nouradel");
        user.setPassword("12345678");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("Collaborator"));
        Authentication authentication=new UsernamePasswordAuthenticationToken(user, "12345678", grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @DataProvider(name = "stores")
    public Object[][] getStores(){
        return new Object[][]{{"s"}};
    }

    @Test
    public void getView(){
        String view = controller.coll();
        assertEquals(view,"collaborator");
    }

   @Test(dataProvider = "stores")
    public void getAllStores(String storeOwner){

       user.setStoreOwner(new StoreOwner(new User(storeOwner,"12345678","nouradel")));
        List<Store> stores = new ArrayList<Store>();
        stores.add(new Store("store1"));
        stores.add(new Store("store2"));

        List<Store> list = controller.getCollabStores();
        int count = 0;
        for(int j=0; j<stores.size(); j++){
            for(int i=0; i<list.size(); i++){
                if(stores.get(j).getStoreName().equals(list.get(i).getStoreName())){
                    count++;
                }
            }
            list.remove(0);
        }
        assertEquals(count,stores.size());
    }
}
