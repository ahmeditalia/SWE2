package SWEProject.Main.TestNG;

import org.testng.annotations.Test;

import SWEProject.Main.Application;

import org.testng.annotations.DataProvider;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StatisticsTest extends AbstractTestNGSpringContextTests{
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeTest
  public void beforeTest() {
  }

}
