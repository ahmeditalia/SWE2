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
import SWEProject.Main.Controller.BrandController;
import SWEProject.Main.Controller.Entities.Brand;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BrandControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private BrandController brandController;

	@DataProvider(name = "validaddbrand")
	public Object[][] validaddbrand() {
		return new Object[][] { { "Brand3", "category3" }, { "Brand4", "category4" }, { "testbrand1", "testcate1" },{ "B2", "cate2" } };
	}

	@DataProvider(name = "invalidaddbrand")
	public Object[][] invalidaddbrand() {
		return new Object[][] { { "brand1", "category1" } };
	}

	@Test(priority = 2, dataProvider = "validaddbrand")
	public void validtest(String[] Case) throws Exception {
		assertEquals(brandController.addBrand(new Brand(Case[0], Case[1])), true);
	}

	@Test(priority = 2, dataProvider = "invalidaddbrand")
	public void invalidtest(String[] Case) throws Exception {
		assertEquals(brandController.addBrand(new Brand(Case[0], Case[1])), false);
	}

	@Test(priority = 1)
	public void allBrandsTest() {
		List<Brand> expected = brandController.brands();
		if (!expected.get(0).getName().equals("brand1") || !expected.get(0).getCategory().equals("category1")) {
			assertTrue(false);
			return;
		}
		if (!expected.get(1).getName().equals("brand2") || !expected.get(1).getCategory().equals("category2")) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}

	@Test(priority=3)
	public void validbrandByProduct() {
		Brand brand = brandController.brands("product1");
		if (!brand.getName().equals("brand1")) {
			assertTrue(false);
			return;
		}
		brand = brandController.brands("product2");
		if (!brand.getName().equals("brand2")) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}
	
	@Test(priority=3)
	public void invalidbrandByProduct() {
		Brand brand = brandController.brands("product1");
		if (!brand.getName().equals("brand1")) {
			assertTrue(false);
			return;
		}
		assertTrue(true);	
	}
}
