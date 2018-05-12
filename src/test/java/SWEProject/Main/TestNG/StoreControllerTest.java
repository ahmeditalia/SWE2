package SWEProject.Main.TestNG;

import static org.testng.Assert.assertTrue;
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
import SWEProject.Main.Controller.StoreController;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StoreControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private StoreController storeController;
	
	@BeforeTest
	public void Setup() {
		User user=new StoreOwner();
		user.setUsername("s");
        user.setEmail("s@gmail.com");
        user.setPassword("12345678");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("NormalUser"));
        Authentication authentication=new UsernamePasswordAuthenticationToken(user, "12345678", grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	@Test(priority = 1)
	public void showAllStore() {
		List<Store> stores = storeController.showAllStores();
		if (!stores.get(0).getStoreName().equals("store1")) {
			assertTrue(false);
			return;
		}
		if (!stores.get(1).getStoreName().equals("store2")) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}	
	
	@DataProvider(name = "validstores")
	public Object[][] validstore() {
		return new Object[][] { { "store1" }, { "store2" } };
	}

	@DataProvider(name = "invalidstores")
	public Object[][] invalidstore() {
		return new Object[][] { { "store99" } };
	}

	@Test(priority = 2, dataProvider = "validstores")
	public void vOpenStore(String[] Case) {
		List<StoreProduct> storeProducts = storeController.openStore(Case[0]);
		for (StoreProduct storeProduct : storeProducts) {
			if (!storeProduct.getStore().getStoreName().equals(Case[0])) {
				assertTrue(false);
				return;
			}
		}
		assertTrue(true);
	}

	@Test(priority = 3, dataProvider = "invalidstores")
	public void invOpnStore(String[] Case) {
		List<StoreProduct> storeProducts = storeController.openStore(Case[0]);
		if (storeProducts.size() > 0) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}
	
	
}
