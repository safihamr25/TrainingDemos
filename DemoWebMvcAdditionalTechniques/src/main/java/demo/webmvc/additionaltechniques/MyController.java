package demo.webmvc.additionaltechniques;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/hello")
	public String show(HttpServletRequest request, Model model) {
		
		String language = request.getParameter("language");
		
		if (language != null && language.equals("French"))
			model.addAttribute("greeting", "Bonjour!");
		else
			model.addAttribute("greeting", "Hello!");
		
		return "displayGreeting";
	}
}
