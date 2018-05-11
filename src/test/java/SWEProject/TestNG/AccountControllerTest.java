package SWEProject.TestNG;
import SWEProject.Main.Controller.AccountController;
import SWEProject.Main.Controller.BrandController;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.UserRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(BrandController.class)
public class AccountControllerTest {
    @Mock
    private UserRepository userRepo;
    @InjectMocks
    private AccountController accountController=new AccountController();
    @BeforeTest
    public void setup(){
        MockitoAnnotations.initMocks(this);
        userRepo = mock(UserRepository.class);
        accountController = new AccountController(userRepo);
    }

    @Test
    public void Test0RegistrationWithValidData(){
        User user = new User("Hosam","password","hosamelkashab@yahoo.com");
        assertEquals(accountController.registration(user,"admin"),"redirect:/login");
    }

}
