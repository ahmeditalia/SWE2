package SWEProject.Selenuim;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*//////////issue////////*/
public class GoBackToLogin {
    @Test
    public  void GoBackToLogin()  {
        String PathChrome = "D:\\FCI\\y3\\swe2\\Selenium\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PathChrome);
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8383/registration");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//html//body/div/form/input[1]")).sendKeys("Admin2");
        driver.findElement(By.xpath("//html//body/div/form/input[2]")).sendKeys("12345678");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        driver.navigate().back();
        String expectedURL="http://localhost:8383/admin-view";
        String actualURL=driver.getCurrentUrl();
        assertEquals(expectedURL,actualURL);
    }
}