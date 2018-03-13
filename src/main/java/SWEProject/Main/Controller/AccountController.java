package SWEProject.Main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import SWEProject.Main.Controller.Entities.Admin;
import SWEProject.Main.Controller.Entities.Creator;
import SWEProject.Main.Controller.Entities.StoreOwner;
import SWEProject.Main.Controller.Entities.User;
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
		String routed = "/";
		if(!userRepository.exists(user.getUsername()))
		{
			user=creator.createUser(type, user);
			userRepository.save(user);
			routed = "redirect:/login";
		}
		else 
		{
			routed = "redirect:/Registration?error";
		}
		return routed;
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model)
	{
		return "login";
	}
	
	@GetMapping("/success")
	public String success(Model model)
	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(user instanceof Admin)
		{
			System.out.println("admin");
			return "redirect:/admin-view";
		}
		else if(user instanceof StoreOwner)
		{
			model.addAttribute(user);
			System.out.println("storeowner");
			return "redirect:/add-store";
		}
		return "login";
	}
}