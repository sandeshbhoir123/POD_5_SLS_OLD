package in.co.school.directory.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.co.school.directory.service.SchoolServiceInt;
import in.co.school.directory.service.SuggestionServiceInt;

@Controller
public class WelcomeCtl {
	
	@Autowired
	private SchoolServiceInt schoolService;
	
	@Autowired
	private SuggestionServiceInt suggestionService;

	@GetMapping("/welcome")
	public String getWelcome() {
		return "welcome";
	}
	
	@GetMapping("/dashbord")
	public String getDashbord(Model model) {
		model.addAttribute("school", schoolService.search(null).size());
		model.addAttribute("suggestion", suggestionService.search(null).size());
		return "dashbord";
	}
	
}
