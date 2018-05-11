package SWEProject.Main.TestNG;


import static org.testng.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SWEProject.Main.Application;
import SWEProject.Main.Controller.BrandController;
import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Repository.BrandRepository;
import SWEProject.Main.Controller.Repository.SystemProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BrandControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private BrandRepository brandRepo;
	@Autowired
	private SystemProductRepository systemProductRepo;
	@Autowired
	private BrandController brandController;
	
	@DataProvider(name = "validaddbrand")
	public Object[][] casesValid() {
		return new Object[][] {{ "Brand1", "category1" }, { "Brand1", "category1" },{ "testbrand1", "testcate1" }, { "B2", "cate2" } };
	}

	@DataProvider(name = "invalidaddbrand")
	public Object[][] casesInvalid() {
		return new Object[][] { { null, null }, { " ", " " } };
	}

	@BeforeTest
	public void setup() {
		brandController = new BrandController(brandRepo,systemProductRepo);
	}

	@Test(dataProvider = "validaddbrand")
	public void validtest(String[] Case) throws Exception {
		Brand brand = new Brand(Case[0], Case[1]);
		// brandController.addBrand(brand);
		// when(brandRepo.existsByName(anyString())).thenReturn(false);
		// when(brandRepo.save(Matchers.any(Brand.class))).thenReturn(brand);
		assertEquals(brandController.addBrand(brand), true);
	}

	// @Test(dataProvider="invalidaddbrand")
	// public void invalidtest(String[] Case) throws Exception {
	// Brand brand = new Brand(Case[0], Case[1]);
	// when(brandRepo.existsByName(anyString())).thenReturn(true);
	// when(brandRepo.save(Matchers.any(Brand.class))).thenReturn(brand);
	// assertEquals(brandController.addBrand(brand), false);
	// }

}

