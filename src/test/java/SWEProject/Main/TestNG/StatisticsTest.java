package SWEProject.Main.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(BrandController.class)
public class StatisticsTest {
	private MockMvc mockMvc;

	  @Mock
	  private BrandRepository brandRepo;

	  @InjectMocks
	  private BrandController brandController;
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
