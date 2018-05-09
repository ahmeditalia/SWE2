package SWEProject.TestNG;

import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import SWEProject.Main.Controller.AdminController;
import SWEProject.Main.Controller.Entities.Admin;
import SWEProject.Main.Controller.Entities.User;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
@AutoConfigureRestDocs
public class AdminControllerTest {

	@Autowired
	MockMvc mockMvc;

	@DataProvider(name = "Valid")
	public Object[][] casesValid() {
		return new Object[][] { { "testbarnd1", "testcate1" } };
	}

	@DataProvider(name = "Invalid")
	public Object[][] casesInvalid() {
		return new Object[][] { { "testbarnd1", "testcate1" }, { " ", " " } };
	}

	@BeforeTest
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(AdminController.class).build();
	}

	@Test
	public void f() throws Exception {
		Admin admin = new Admin(new User("test1", "passtest", "testmail"));
		MvcResult mvcResult = mockMvc.perform(get("/add-admin").param("admin", admin.toString())).andReturn();
		System.out.println("Retrun : "+mvcResult.toString());
	}

}
