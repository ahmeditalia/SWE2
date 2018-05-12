package SWEProject.Main.TestNG;

import SWEProject.Main.Application;
import SWEProject.Main.Controller.CartController;
import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.NormalUser;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.WebSecurityAuthenticator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@EnableTransactionManagement
@ContextConfiguration
@Transactional
public class CartControllerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private CartController cartController;
    @DataProvider(name = "validaddbrand")
    public Object[][] validaddtocart() {
        return new Object[][] {{"product1-store1"}};
    }
    @BeforeTest
    @Transactional
    public void Setup(){
        User user=new NormalUser();
        user.setUsername("n");
        user.setEmail("n@gmail.com");
        user.setPassword("12345678");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("NormalUser"));
        Authentication authentication=new UsernamePasswordAuthenticationToken(user, "12345678", grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    @Test(dataProvider = "validaddbrand")
    @Transactional
    public void validtest(String[] Case) throws Exception {
        assertEquals(cartController.addToCart(Case[0]), true);
    }

}
