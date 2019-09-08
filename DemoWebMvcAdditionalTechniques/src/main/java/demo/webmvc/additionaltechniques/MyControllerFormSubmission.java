package demo.webmvc.additionaltechniques;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/processEmployee")
public class MyControllerFormSubmission {

	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeeForm(@RequestParam(value="id", required=false, defaultValue="0") int id, Model model) {
		model.addAttribute("employee", new Employee(id));
		return "employee";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String submitEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		model.addAttribute("employeeSummary", employee);
		return "employeeSummary";
	}
}
