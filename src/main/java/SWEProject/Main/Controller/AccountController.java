package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import SWEProject.Main.Controller.Repository.UserRepository;
@Controller
public class AccountController {
	@Autowired
	private UserRepository userRepository;
	private Creator creator=Creator.getInstance();
	@GetMapping("/Registration")
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("user",new User());
		return "Registration";
	}
	@PostMapping("/Registration")
	public String registration(@ModelAttribute User user, @RequestParam("type") String type)
	{
		if(!userRepository.exists(user.getUsername()))
		{
			user=creator.createUser(type, user);
			System.out.print("iiiiiiiiiii"+user.getEmail());
			userRepository.save(user);
			return "redirect:/login";
		}
		return "redirect:/Registration?error";
	}
	@GetMapping("/login")
	public String showLoginForm(Model model)
	{
		return "login";
	}
	@GetMapping("/normal-user-view")
	public String showLogin(Model model)
	{
		return "normal-user-view";
	}
	@GetMapping("/success")
	public String success(Model model)
	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof Admin)
		{
			return "redirect:/admin-view";
		}
		else if(user instanceof StoreOwner)
		{
			return "redirect:/store-owner-view";
		}
		else if(user instanceof NormalUser)
		{
			return "redirect:/normal-user-view";
		}

		return "login";
	}
}