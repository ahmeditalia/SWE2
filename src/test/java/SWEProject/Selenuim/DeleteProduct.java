package SWEProject.Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class DeleteProduct {

    private WebDriver driver;

    @BeforeMethod
    public void openLoginPage() {

        driver.get("http://localhost:8383/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);

        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("321");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345678");

        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
    }

    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Desktop\\assignment2\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void validTest() {

        driver.findElement(By.xpath("//*[@id=\"list\"]/option[2]")).click();
        String delted = driver.findElement(By.xpath("//*[@id=\"body\"]/tr")).getText();
        driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();

        boolean found = false;
        List<WebElement> rows = driver.findElement(By.xpath("//*[@id=\"body\"]")).findElements(By.tagName("tr"));

        for (int i = 0; i < rows.size(); i++) {

            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for (WebElement w : cols) {
                if (w.getText().toLowerCase().contains(delted.toLowerCase())) {
                    found = true;
                    break;
                }
            }
        }
        assertEquals(found, false);
    }
}
