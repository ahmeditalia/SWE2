package SWEProject.Main.Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class AddProductToStore {

    private WebDriver driver;

    @DataProvider(name = "valid")
    public Object[][] validTest(){
        return  new Object[][]{{"120","12"},{"132","12345678987654321"}};
    }

    @DataProvider(name = "invalid")
    public Object[][] invalidTest(){
        return  new Object[][]{{"-120","-12"}};
    }
    @BeforeMethod
    public void openLoginPage(){

        driver.get("http://localhost:8383/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);

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
        driver.findElement(By.xpath("//*[@id=\"addprodcttostore\"]")).click();

        String option = driver.findElement(By.xpath("//*[@id=\"ProductName\"]/option")).getText();
        driver.findElement(By.xpath("//*[@id=\"ProductName\"]/option")).click();
        driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(price);
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys(quantity);
        driver.findElement(By.xpath("//*[@id=\"submitprodcttostore\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[@id=\"list\"]/option[1]")).click();
        boolean found = false;
        List<WebElement> rows = driver.findElement(By.xpath("//*[@id=\"body\"]")).findElements(By.tagName("tr"));

        for(int i=0; i<rows.size(); i++) {

            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for (WebElement w : cols) {
                if(w.getText().toLowerCase().contains(option.toLowerCase())) {
                    found = true;
                    break;
                }
            }
        }
        assertEquals(found,true);
    }

    @Test(dataProvider = "invalid")
    public void  invalid(String price,String quantity){

        driver.findElement(By.xpath("//*[@id=\"list\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"addprodcttostore\"]")).click();

        String option = driver.findElement(By.xpath("//*[@id=\"ProductName\"]/option")).getText();
        driver.findElement(By.xpath("//*[@id=\"ProductName\"]/option")).click();
        driver.findElement(By.xpath("//*[@id=\"price\"]")).sendKeys(price);
        driver.findElement(By.xpath("//*[@id=\"quantity\"]")).sendKeys(quantity);
        driver.findElement(By.xpath("//*[@id=\"submitprodcttostore\"]")).click();

        assertTrue(driver.findElement(By.xpath("//*[@id=\"addproduct\"]")).isDisplayed());
    }
    @AfterTest
    public void close(){ driver.close(); }
}
