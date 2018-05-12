package SWEProject.TestNG;

import SWEProject.Main.Application;
import SWEProject.Main.Controller.CommandController;
import SWEProject.Main.Controller.Entities.StoreProduct;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CommandControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CommandController controller;


    @DataProvider(name = "validTest")
    public Object[][] valid(){
        return new Object[][]{{"product3","100","25","exist","store1"}};
    }

    @DataProvider(name = "invalidTest")
    public Object[][] invalid(){
        return new Object[][]{{"product1","17","1000","exist","store1"}};
    }

    @DataProvider(name = "validDelete")
    public Object[][] validDelete(){
        return new Object[][]{{"3"}};
    }

    @DataProvider(name = "invalidDelete")
    public Object[][] invalidDelete(){
        return new Object[][]{{"10"}};
    }

    @DataProvider(name = "validEdit")
    public Object[][] validEdit(){
        return new Object[][]{{"6","100","10"}};
    }

    @DataProvider(name = "invalidEdit")
    public Object[][] invalidEdit(){
        return new Object[][]{{"19","199","12"}};
    }

    @Test(dataProvider = "validTest")
    public void validTest(String name,String quantity,String price, String exist,String storeName){

        StoreProduct product = new StoreProduct();
        product.setName(name);
        product.setQuantity(Integer.parseInt(quantity));
        product.setPrice(Double.parseDouble(price));
        product.setExist(exist);
        assertEquals(controller.addProduct(product,storeName),true);
    }

    @Test(dataProvider = "invalidTest")
    public void invalidTest(String name,String quantity,String price, String exist,String storeName){

        StoreProduct product = new StoreProduct();
        product.setName(name);
        product.setQuantity(Integer.parseInt(quantity));
        product.setPrice(Double.parseDouble(price));
        product.setExist(exist);

        assertEquals(controller.addProduct(product,storeName),false);
    }

    @Test(dataProvider = "validDelete")
    public void validDeleteTest(String productId){

       assertTrue(controller.deleteProduct(Integer.parseInt(productId)));
    }

    @Test(dataProvider = "invalidDelete")
    public void invalidDeleteTest(String productId){

        assertTrue(!controller.deleteProduct(Integer.parseInt(productId)));
    }

    @Test(dataProvider = "validEdit")
    public void validEditTest(String productId,String quantity, String price){

        assertTrue(controller.editProduct(Integer.parseInt(productId),Integer.parseInt(quantity),Double.parseDouble(price)));
    }

    @Test(dataProvider = "invalidEdit")
    public void invalidEditTest(String productId,String quantity, String price){

        assertTrue(!controller.editProduct(Integer.parseInt(productId),Integer.parseInt(quantity),Double.parseDouble(price)));
    }

}
