package SWEProject.Main.Selenuim;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class BuyProduct {
    @Test
    public  void BrandAndCategoryExist() throws InterruptedException {
        String PathChrome = "D:\\FCI\\y3\\swe2\\Selenium\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PathChrome);
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8383/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//html//body/div/form/input[1]")).sendKeys("Admin2");
        driver.findElement(By.xpath("//html//body/div/form/input[2]")).sendKeys("12345678");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"addbrandtosystem\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"namebrand\"]")).sendKeys("brand22");
        driver.findElement(By.xpath("//*[@id=\"categorybrand\"]")).sendKeys("cateory22");
        driver.findElement(By.xpath("//*[@id=\"submitbrand\"]")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"addbrandtosystem\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"namebrand\"]")).sendKeys("brand22");
        driver.findElement(By.xpath("//*[@id=\"categorybrand\"]")).sendKeys("cateory22");
        driver.findElement(By.xpath("//*[@id=\"submitbrand\"]")).click();
        Thread.sleep(1000);
        alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"addproduct\"]")).click();
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"brand\"]")));
        List<WebElement> options = select.getOptions();
        int count=0;
        for (int i=0;i<options.size();i++) {
            if("brand22".equals(options.get(i).getText())){
                count++;
            }
        }
        assertEquals(1,count);
    }
}