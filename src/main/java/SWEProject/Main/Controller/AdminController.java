package SWEProject.Main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {
	
	@GetMapping("/adminView")
	public String loadView(Model model)
	{
		model.addAttribute("direct", new String());
		return "adminView";
	}
	
	@PostMapping("/adminView")
	public String redirect(@ModelAttribute String s)
	{
		return "redirect:/"+s;
	}
	
	
}
