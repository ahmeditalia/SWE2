package SWEProject.TestNG;
import SWEProject.Main.Controller.BrandController;
import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Repository.BrandRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class adminController {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private BrandRepository brandRepo;

  @InjectMocks
  private BrandController brandController=new BrandController();

  @DataProvider(name = "valid")
  public Object[][] validInput(){ return new Object[][]{{"b2","c1"}}; }

  @DataProvider(name = "invalid")
  public Object[][] invalidInput(){ return new Object[][]{{"b1","c1"}}; }

  @BeforeTest
  public void setup(){
    MockitoAnnotations.initMocks(this);
    brandRepo = mock(BrandRepository.class);
    brandController = new BrandController(brandRepo);
  }


  @Test(dataProvider = "valid")
  public void validTest(String name, String category){

    Brand brand = new Brand(name,category);
    //when(brandRepo.existsByName(anyString())).thenReturn(false);
    //when(brandRepo.save(Matchers.any(Brand.class))).thenReturn(brand);
    assertEquals(brandController.addBrand(brand),true);
  }

  @Test(dataProvider = "valid")
  public void invalidTest(String name, String category){

    Brand brand = new Brand(name,category);
    //when(brandRepo.existsByName(anyString())).thenReturn(true);
    //when(brandRepo.save(Matchers.any(Brand.class))).thenReturn(brand);
    assertEquals(brandController.addBrand(brand),false);
  }

}
