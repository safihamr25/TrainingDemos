package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.business.Shipper;
import com.example.demo.business.ShipperRepository;




@Controller
public class MyControllerThymeLeaf {
	@Autowired
	ShipperRepository shipperrepo;

	@RequestMapping("/")
	String homehandler(Model model) {
		model.addAttribute("newShipper", new Shipper());
		return "index";
	}

	@RequestMapping("/shippers")
	String shippershandler(Model model) {
		model.addAttribute("shippers", shipperrepo.allShippers());
		return "shippers";
	}

	@RequestMapping(value="/addShipper")
	public String handleAddCustomer(@ModelAttribute Shipper newShipper, Model model){
		System.out.println("Adding new Shipper: " + newShipper);
		shipperrepo.addShipper(newShipper);
		model.addAttribute("shippers", shipperrepo.allShippers());
		return "shippers";
	}
	
	@RequestMapping("/edit/{id}")
	String shipperupdatehandler(@PathVariable("id") String id, Model model) {
		model.addAttribute("shipper", shipperrepo.getShipper(Integer.parseInt(id)));
		return "edit";
	}
	
	@RequestMapping("/delete/{id}")
	String shipperdeletehandler(@PathVariable("id") String id, Model model) {
//		model.addAttribute("shipper", shipperrepo.deleteShipper(Integer.parseInt(id)));
		shipperrepo.deleteShipper(Integer.parseInt(id));
		model.addAttribute("shippers", shipperrepo.allShippers());
		return "shippers";
	}

	@RequestMapping("/save")
	String shippersavehandler(HttpServletRequest request, Model model) {
		Shipper s = new Shipper(Integer.parseInt(request.getParameter("id")),
				request.getParameter("name"),request.getParameter("phone"));
		shipperrepo.saveShipper(s);
		model.addAttribute("shippers", shipperrepo.allShippers());
		return "shippers";
	}
	
}