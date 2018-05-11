package SWEProject.Selenuim;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
/*//////////issue////////*/
import static org.junit.Assert.assertEquals;
public class RegistrationTest {
    @Test
    public  void RegistrationTestwithnoAccountType() throws InterruptedException {
        String PathChrome = "D:\\FCI\\y3\\swe2\\Selenium\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PathChrome);
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8383/Registration");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("hosamreda");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hosam@he5a.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("he5ahe5a");
        driver.findElement(By.xpath("/html/body/div/form/input[4]")).click();
        String expcted="Register";
        String actual=driver.findElement(By.xpath("/html/body/h1")).getText();

        assertEquals(expcted,actual);
    }
}