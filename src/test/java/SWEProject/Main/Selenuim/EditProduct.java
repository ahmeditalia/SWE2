package SWEProject.Main.Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class EditProduct {

    private WebDriver driver;

    @DataProvider(name = "valid")
    public Object[][] validTest(){ return new Object[][]{{"15","183"},{"15","1234567899876"}}; }

    @DataProvider(name = "negativeInput")
    public Object[][] invalidTest(){ return new Object[][]{{"-12","-132"}}; }

    @BeforeMethod
    public void openLoginPage(){

        driver.get("http://localhost:8383/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(65L, TimeUnit.SECONDS);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("s");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345678");

        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
    }

    @BeforeTest
    public void start(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Desktop\\assignment2\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "valid")
    public void validTest(String price, String quantity){

        driver.findElement(By.xpath("//*[@id=\"list\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[8]")).click();
        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[3]")).clear();
        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[3]")).sendKeys(price);

        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[7]")).clear();
        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[7]")).sendKeys(quantity);
        driver.findElement(By.xpath("//*[@id=\"done\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id=\"list\"]/option[1]")).click();
        boolean found = false;

        if(driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[7]")).getText().equalsIgnoreCase(quantity)
                && driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[3]")).getText().equalsIgnoreCase(price))
            found = true;

        assertEquals(found,true);
    }

    @Test(dataProvider = "negativeInput")
    public void  invalid(String price,String quantity){

        driver.findElement(By.xpath("//*[@id=\"list\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[8]")).click();

        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[3]")).clear();
        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[3]")).sendKeys(price);

        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[7]")).clear();
        driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[7]")).sendKeys(quantity);
        driver.findElement(By.xpath("//*[@id=\"done\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"list\"]/option[1]")).click();
        boolean found = false;

        if(driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[7]")).getText().equalsIgnoreCase(quantity)
                && driver.findElement(By.xpath("//*[@id=\"body\"]/tr[1]/td[3]")).getText().equalsIgnoreCase(price))
            found = true;

        assertEquals(found,false);
    }

    @AfterTest
    public void close(){ driver.close(); }

}
