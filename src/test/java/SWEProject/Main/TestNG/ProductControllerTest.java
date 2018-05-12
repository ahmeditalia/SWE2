package SWEProject.Main.TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import SWEProject.Main.Application;
import SWEProject.Main.Controller.ProductController;
import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Entities.SystemProduct;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ProductController productController;
	
	@Test(priority=1)
	public void allSystemProduct() {
		List<SystemProduct> systemProducts = (List<SystemProduct>) productController.allSystemProduct();
		if(!systemProducts.get(0).getName().equals("product1")) {
			assertTrue(false);
			return;
		}
		if(!systemProducts.get(1).getName().equals("product2")) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}
	
	@Test(priority=2)
	public void allStoreProduct() {
		List<StoreProduct> storeProducts = (List<StoreProduct>) productController.products();
		if(!storeProducts.get(0).getName().equals("product1") || !storeProducts.get(0).getStore().getStoreName().equals("store1")) {
			assertTrue(false);
			return;
		}
		if(!storeProducts.get(1).getName().equals("product2") || !storeProducts.get(1).getStore().getStoreName().equals("store1")) {
			assertTrue(false);
			return;
		}
		if(!storeProducts.get(2).getName().equals("product1") || !storeProducts.get(2).getStore().getStoreName().equals("store2")) {
			assertTrue(false);
			return;
		}
		if(!storeProducts.get(3).getName().equals("product2") || !storeProducts.get(3).getStore().getStoreName().equals("store2")) {
			assertTrue(false);
			return;
		}		
		assertTrue(true);
	}

	@Test(priority=3)
	public void storeProductByName() {
		List<String> slist = new ArrayList<String>();
		slist.add("store1");
		List<StoreProduct> storeProducts = productController.StoreProducts(slist);
		if(!storeProducts.get(0).getName().equals("product1") || !storeProducts.get(0).getStore().getStoreName().equals("store1")) {
			assertTrue(false);
			return;
		}
		if(!storeProducts.get(1).getName().equals("product2") || !storeProducts.get(1).getStore().getStoreName().equals("store1")) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}
	
	@DataProvider(name = "validprobrand")
	public Object[][] validprobrand() {
		return new Object[][] { {"brand1"},{"brand2"} };
	}
	
	@DataProvider(name = "invalidprobrand")
	public Object[][] invalidprobrand() {
		return new Object[][] { {"brand9999"}};
	}
	
	@Test(priority=4,dataProvider="validprobrand")
	public void vproductsOfBrand(String[] Case) {
		List<SystemProduct> systemProducts = productController.productsOfBrand(Case[0]);
		for(SystemProduct systemProduct:systemProducts) {
			if(!systemProduct.getBrand().getName().equals(Case[0])) {
				assertTrue(false);
				return;
			}
		}
		assertTrue(true);
	}
	
	@Test(priority=5,dataProvider="invalidprobrand")
	public void invproductsOfBrand(String[] Case) {
		List<SystemProduct> systemProducts = productController.productsOfBrand(Case[0]);
		if(systemProducts.size()>0) {
			assertTrue(false);
			return;
		}
		assertTrue(true);
	}
	
	@DataProvider(name = "validaddproduct")
	public Object[][] vaddproductcases() {
		return new Object[][] { {"p1", "brand1", "category1","type45"},{"p2", "brand1", "category1","type49"} };
	}
	
	@DataProvider(name = "invalidaddproduct")
	public Object[][] invalidaddproduct() {
		return new Object[][] { {"product1", "brand1", "category1","type1"}};
	}

	@Test(priority=7,dataProvider = "validaddproduct")
	public void validaddproduct(String[] Case) {
		SystemProduct systemProduct = new SystemProduct();
		systemProduct.setName(Case[0]);
		systemProduct.setBrand(new Brand(Case[1],Case[2]));
		systemProduct.setType(Case[3]);
		assertEquals(productController.addProduct(systemProduct), true);
	}
	
	@Test(priority=8,dataProvider="invalidaddproduct")
	public void invalidproduct(String[] Case) {
		SystemProduct systemProduct = new SystemProduct();
		systemProduct.setName(Case[0]);
		systemProduct.setBrand(new Brand(Case[1],Case[2]));
		systemProduct.setType(Case[3]);
		assertEquals(productController.addProduct(systemProduct), false);
	}
}
