package SWEProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import SWEProject.Entities.User;
import SWEProject.Repository.UserRepository;

@Controller
public class AccountController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/Registration")
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("user",new User() {});
		return "Registration";
	}
	
	@PostMapping("/Registration")
	public String registration(@ModelAttribute User user)
	{
		userRepository.save(user);
		return "login";	
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model)
	{
		model.addAttribute("user",new User() {});
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user)
	{
		if(userRepository.existsByID(user.getUsername(), user.getPassword()))
		{
			return "add-product";
		}
		return "login";
	}
}