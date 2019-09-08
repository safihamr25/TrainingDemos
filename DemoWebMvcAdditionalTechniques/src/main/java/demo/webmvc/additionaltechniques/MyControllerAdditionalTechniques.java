package demo.webmvc.additionaltechniques;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/techniques")
@SessionAttributes({"myCounter1", "myCounter2"})
public class MyControllerAdditionalTechniques {

	@RequestMapping("/example1a")
	public String showUrla(Model model) {
		model.addAttribute("greeting", "You requested /techniques/example1");
		return "displayGreeting";
	}

	@RequestMapping("/example1b")
	public String showUrlb(HttpServletRequest request, Model model) {
		model.addAttribute("greeting", "You requested " + request.getRequestURI());
		return "displayGreeting";
	}

	@RequestMapping("/example2")
	public String showName(Model model,
			               @RequestParam("firstName") String fn,
			               @RequestParam(value="middleName", required=false) String mn,
			               @RequestParam("lastName") String ln) {
		
		if (mn == null) 
			model.addAttribute("fullName", fn + " " + ln);
		else
			model.addAttribute("fullName", fn + " " + mn + " " + ln);
	
		return "displayFullName";
	}


	@RequestMapping(value="/example3", params="country=cy")
	public String showNameWelsh(Model model,
			                    @RequestParam("firstName") String fn,
			                    @RequestParam(value="middleName", required=false) String mn,
			                    @RequestParam("lastName") String ln) {
		
		if (mn == null) 
			model.addAttribute("fullName", fn + " " + ln + ", sut rydych chi?");
		else
			model.addAttribute("fullName", fn + " " + mn + " " + ln + ", sut rydych chi?");
	
		return "displayFullName";
	}
	
	
	@RequestMapping(value="/example3", params="country=fr")
	public String showNameFrench(Model model,
			                     @RequestParam("firstName") String fn,
			                     @RequestParam(value="middleName", required=false) String mn,
			                     @RequestParam("lastName") String ln) {
		
		if (mn == null) 
			model.addAttribute("fullName", fn + " " + ln + ", ca va?");
		else
			model.addAttribute("fullName", fn + " " + mn + " " + ln + ", ca va?");
	
		return "displayFullName";
	}
	
	
	@RequestMapping(value="/example3", params="!country")
	public String showNameDefault(Model model,
                                  @RequestParam("firstName") String fn,
                                  @RequestParam(value="middleName", required=false) String mn,
                                  @RequestParam("lastName") String ln) {
		
		if (mn == null) 
			model.addAttribute("fullName", fn + " " + ln + ", how are you?");
		else
			model.addAttribute("fullName", fn + " " + mn + " " + ln + ", how are you?");
	
		return "displayFullName";
	}

	
	@RequestMapping(value="/example4")
	public String incrementMyCounters(ModelMap model) {
		
		Integer myCounter1 = (Integer)model.get("myCounter1");
		if (myCounter1 == null) {
			model.addAttribute("myCounter1", 1);
		}
		else {
			model.addAttribute("myCounter1", myCounter1.intValue() + 1);
		}
		
		Integer myCounter2 = (Integer)model.get("myCounter2");
		if (myCounter2 == null) {
			model.addAttribute("myCounter2", 2);
		}
		else {
			model.addAttribute("myCounter2", myCounter2.intValue() + 2);
		}
		
		return "displayMyCounters";
	}
	
	
	@ModelAttribute("players")
	public Collection<String> populatePlayers() {
		
		Collection<String> players = new ArrayList<String>();
		players.add("Lucasz Fabianski");
		players.add("Leon Britton");
		players.add("Wilfried Bony");
		return players;
	}
		
	@RequestMapping(value="/example5")
	public String displayPlayers(ModelMap model) {
		
		@SuppressWarnings("unchecked")
		Collection<String> players = (Collection<String>) model.get("players");

		players.add("Lionel Messi");
		players.add("its me");
		return "displayPlayers";
	}
	
	@Autowired
	private MyService service;
	
	@RequestMapping("/example6a")
	public String showTimestamp(Model model) {		
		model.addAttribute("timestamp", service.getTimestamp());
		return "displayTimestamp";
	}
	
	@RequestMapping("/example6b")
	public String showMessage(Model model) {
		model.addAttribute("message", service.getMessage());
		return "displayMessage";
	}
}
