package SWEProject.Main.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SWEProject.Main.Application;
import SWEProject.Main.Controller.AdminController;
import SWEProject.Main.Controller.Entities.Admin;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AdminControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private AdminController adminController;

	@DataProvider(name = "validaddadmin")
	public Object[][] casesValid() {
		return new Object[][] { { "admin1", "admin@admin.com", "12345678" },
				{ "admin2", "admin@admin.com", "12345678" }, { "admin3", "admin@admin.com", "12345678" } };
	}

	@DataProvider(name = "invalidaddadmin")
	public Object[][] casesInvalid() {
		return new Object[][] {{ "admin1", "admin@admin.com", "12345678" }};
	}

	@Test(priority = 4, dataProvider = "validaddadmin")
	public void validaddadmin(String[] Case) throws Exception {
		assertEquals(adminController.addAdmin(new Admin(new User(Case[0], Case[1], Case[2]))), true);
	}

	@Test(priority = 5, dataProvider = "invalidaddadmin")
	public void invalidaddadmin(String[] Case) throws Exception {
		assertEquals(adminController.addAdmin(new Admin(new User(Case[0], Case[1], Case[2]))), false);
	}

	@Test(priority = 1)
	public void viewrequests() {
		List<Store> stores = adminController.Viewrequests();
		if (!stores.get(0).getStoreName().equals("store3")) {
			assertTrue(false);
			return;
		}
		if (!stores.get(1).getStoreName().equals("store4")) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}

	@Test(priority = 2)
	public void accept() {
		adminController.accept("store3");
		if (adminController.requestNumber() > 1) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}

	@Test(priority = 3)
	public void reject() {
		adminController.reject("store4");
		if (adminController.requestNumber() > 0) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}
}
