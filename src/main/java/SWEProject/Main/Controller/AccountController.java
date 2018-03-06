package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SWEProject.Main.Controller.Entities.Admin;
import SWEProject.Main.Controller.Entities.User;
import SWEProject.Main.Controller.Repository.UserRepository;

@Controller
public class AccountController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/Registration")
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("user",new User());
		return "Registration";
	}

	
	@PostMapping("/Registration")
	public String registration(@ModelAttribute User user, @RequestParam("type") String type)
	{
		String routed = "/";
		if(type.equals("admin"))
		{
			if(!userRepository.exists(user.getUsername())) {
				Admin admin = new Admin(user);
				userRepository.save(admin);
				routed = "redirect:/login";
			} else {
				routed = "redirect:/Registration?error";
			}
		}
		return routed;
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model)
	{
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user)
	{
		if(userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword()))
		{
			User repoUser=userRepository.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
			if(repoUser instanceof Admin)
			{
				System.out.println("admin");
				return "redirect:/admin-view";
			}

		}
		return "login";
	}
}