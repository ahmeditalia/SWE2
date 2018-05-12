package SWEProject.Main.TestNG;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
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
import SWEProject.Main.Application;
import SWEProject.Main.Controller.StoreOwnerController;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StoreOwnerControllerTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private StoreOwnerController storeOwnerController;
	
	@DataProvider(name="validaddcollaborator")
	public Object[][] validadd(){
		return new Object[][] {{"col1","col1@col1.com","12345678"},{"col2","col2@col2.com","12345678"}};
	}
	
	@DataProvider(name="invalidaddcollaborator")
	public Object[][] invalidadd(){
		return new Object[][] {{"col1","col1@col1.com","12345678"}};
	}
	
	@BeforeTest
	public void Setup() {
		User user=new StoreOwner();
		user.setUsername("hosam");
        user.setEmail("hhhh");
        user.setPassword("12345678");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("StoreOwner"));
        Authentication authentication=new UsernamePasswordAuthenticationToken(user, "12345678", grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	@Test(priority=1,dataProvider="validaddcollaborator")
	public void validaddcollaborator(String[] Case) {
		assertEquals(storeOwnerController.addCollaborator(new User(Case[0], Case[1], Case[2])), true);
	}
	
	@Test(priority=2,dataProvider="invalidaddcollaborator")
	public void invalidaddcollaborator(String[] Case) {
		assertEquals(storeOwnerController.addCollaborator(new User(Case[0], Case[1], Case[2])), false);
	}
}
