package SWEProject.Main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {
	
	@GetMapping("/admin-view")
	public String loadView()
	{
		return "admin-view";
	}
	

}
